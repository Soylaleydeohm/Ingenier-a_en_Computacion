#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>
#include<unistd.h>

#define MAXENTRADA 30
#define MAXCOLAESPECIFICA 15

sem_t sem_entrada,sem_lugaresEmpresa,sem_lugaresComun,sem_lugaresPolitico;
sem_t sem_colaEmpresa,sem_colaComun,sem_colaPolitico;
sem_t sem_empleadoEmpresa,sem_empleadoComun,sem_prioridad;

void *entrada_empresa(){
  while(1){
    if(sem_trywait(&sem_entrada)==0){
        printf("Cliente empresa llega a la cola de entrada\n");
        fflush(stdout);
        sem_post(&sem_colaEmpresa);
    }
    else {
      //  printf("Cliente llega a la cola de entrada pero está llena y se retira\n");
    }
  }
}

void *entrada_comun(){
  while(1){
    if(sem_trywait(&sem_entrada)==0){
        printf("Cliente comun llega a la cola de entrada\n");
        fflush(stdout);
        sem_post(&sem_colaComun);
    } else {
        //printf("Cliente llega a la cola de entrada pero está llena y se retira\n");
    }
  }
}

void *entrada_politico(){
  while(1){
    if(sem_trywait(&sem_entrada)==0){
        printf("Cliente politico llega a la cola de entrada\n");
        fflush(stdout);
        sem_post(&sem_colaPolitico);
    } else {
       // printf("Cliente llega a la cola de entrada pero está llena y se retira\n");
    }
  }
}

void *cola_empresa(){
  while(1){
    sem_wait(&sem_colaEmpresa);
    sem_wait(&sem_lugaresEmpresa);
    printf("Cliente empresa de la mesa de entrada despachado a cola de empresas\n");
    fflush(stdout);
    sem_post(&sem_entrada);
    sem_post(&sem_empleadoEmpresa);
  }
}

void *cola_comun(){
  while(1){
    sem_wait(&sem_colaComun);
    sem_wait(&sem_lugaresComun);
    printf("Cliente usuario común de la mesa de entrada despachado a cola de usuarios comunes\n");
    fflush(stdout);
    sem_post(&sem_entrada);
    sem_post(&sem_empleadoComun);
  }
}

void *cola_politico(){
  while(1){
    sem_wait(&sem_colaPolitico);
    sem_wait(&sem_lugaresPolitico);
    printf("Cliente político de la mesa de entrada despachado con prioridad a alguna cola\n");
    fflush(stdout);
    sem_post(&sem_entrada);
    sem_post(&sem_prioridad);
  }
}

void *empleado_empresa1(){
while(1){
  while(sem_trywait(&sem_prioridad)==-1){
    sem_wait(&sem_empleadoEmpresa);
    printf("Cliente empresa siendo atendido por empleado para empresas 1\n");
    fflush(stdout);
    sleep(5);
    printf("Cliente empresa se retira al realizar trámite con empleado para empresas 1\n");
    sem_post(&sem_lugaresEmpresa);
  }
  printf("Cliente político siendo atendido con prioridad por empleado para empresas 1\n");
  fflush(stdout);
  sleep(5);
  printf("Cliente politico se retira al realizar trámite con empleado para empresas 1\n");
  sem_post(&sem_lugaresPolitico);
  }
}

void *empleado_empresa2(){
while(1){
  while(sem_trywait(&sem_prioridad)==-1){
    sem_wait(&sem_empleadoEmpresa);
    printf("Cliente empresa siendo atendido por empleado para empresas 2\n");
    fflush(stdout);
    sleep(5);
    printf("Cliente empresa se retira al realizar trámite con empleado para empresas 2\n");
    sem_post(&sem_lugaresEmpresa);
  }
  printf("Cliente político siendo atendido con prioridad por empleado para empresas 2\n");
  fflush(stdout);
  sleep(5);
  printf("Cliente politico se retira al realizar trámite con empleado para empresas 2\n");
  sem_post(&sem_lugaresPolitico);
  }
}

void *empleado_comun(){
while(1){
  while(sem_trywait(&sem_prioridad)==-1){
    sem_wait(&sem_empleadoComun);
    printf("Cliente comun siendo atendido por empleado para usuarios comunes\n");
    fflush(stdout);
    sleep(5);
    printf("Cliente comun se retira al realizar trámite con empleado para usuarios comunes\n");
    sem_post(&sem_lugaresComun);
  }
  printf("Cliente político siendo atendido con prioridad por empleado para usuarios comunes\n");
  fflush(stdout);
  sleep(5);
  printf("Cliente politico se retira al realizar trámite con empleado para usuarios comunes\n");
  sem_post(&sem_lugaresPolitico);
  }
}

int main()
{
  /*Inicialización de semáforos*/
    sem_init(&sem_entrada,0,MAXENTRADA);
    sem_init(&sem_lugaresEmpresa,0,MAXCOLAESPECIFICA);
    sem_init(&sem_lugaresComun,0,MAXCOLAESPECIFICA);
    sem_init(&sem_lugaresPolitico,0,3*MAXCOLAESPECIFICA);
    sem_init(&sem_colaEmpresa,0,0);
    sem_init(&sem_colaComun,0,0);
    sem_init(&sem_colaPolitico,0,0);
    sem_init(&sem_empleadoEmpresa,0,0);
    sem_init(&sem_empleadoComun,0,0);
    sem_init(&sem_prioridad,0,0);
  /*Creacion de hilos*/
    pthread_t hentrada_empresa;
    pthread_t hentrada_comun;
    pthread_t hentrada_politico;
    pthread_t hcola_empresa;
    pthread_t hcola_comun;
    pthread_t hcola_politico;
    pthread_t hempleado_empresa1;
    pthread_t hempleado_empresa2;
    pthread_t hempleado_comun;
    pthread_create(&hentrada_empresa,NULL,entrada_empresa,NULL);
    pthread_create(&hentrada_comun,NULL,entrada_comun,NULL);
    pthread_create(&hentrada_politico,NULL,entrada_politico,NULL);
    pthread_create(&hcola_empresa,NULL,cola_empresa,NULL);
    pthread_create(&hcola_comun,NULL,cola_comun,NULL);
    pthread_create(&hcola_politico,NULL,cola_politico,NULL);
    pthread_create(&hempleado_empresa1,NULL,empleado_empresa1,NULL);
    pthread_create(&hempleado_empresa2,NULL,empleado_empresa2,NULL);
    pthread_create(&hempleado_comun,NULL,empleado_comun,NULL);
    pthread_join (hentrada_empresa,NULL);
    pthread_join (hentrada_comun,NULL);
    pthread_join (hentrada_politico,NULL);
    pthread_join (hcola_empresa,NULL);
    pthread_join (hcola_comun,NULL);
    pthread_join (hcola_politico,NULL);
    pthread_join (hempleado_empresa1,NULL);
    pthread_join (hempleado_empresa2,NULL);
    pthread_join (hempleado_comun,NULL);
    return 0;
}
