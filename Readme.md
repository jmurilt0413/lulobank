## Tabla de contenido
1. [Informacion general](general-info)
2. [Tecnologías](technologies)
3. [Ejecución](installation)
### General Info
***
Este proyecto fue creado con el proposito de consumir los servicios de DummyApiRest por medio de una prueba de smoke a los EndPoint:
```
http://dummy.restapiexample.com/api/v1/employee/{id}
http://dummy.restapiexample.com/api/v1/create
http://dummy.restapiexample.com/api/v1/delete/{id}

```
## Tecnologías
***
Esta es la lista de tecnologias utilizadas:
* [Serenity-Cumcumber](https://mvnrepository.com/artifact/net.serenity-bdd/serenity-cucumber/)
* [Serenity-Rest](https://mvnrepository.com/artifact/net.serenity-bdd/serenity-cucumber/)
* [Serenity-WebDriver](https://mvnrepository.com/artifact/net.serenity-bdd/serenity-screenplay-webdriver/)
* [Serenity-Core](https://mvnrepository.com/artifact/net.serenity-bdd/serenity-core/)
* [Serenity-ScreenPlay](https://mvnrepository.com/artifact/net.serenity-bdd/serenity-screenplay/)
* [Jackson](https://mvnrepository.com/search?q=jackson)
* [Hamcrest](https://mvnrepository.com/artifact/org.hamcrest/hamcrest-all/1.3)
* [Lombok](https://mvnrepository.com/artifact/org.projectlombok)
## Ejecución
***
Para construir el proyecto:
```
mvn clean install
```
Para ejecutar los test:
```
mvn clean -Dtest=ValidarServiciosDummyRunner test 
```
Para generar el reporte:
```
mvn serenity:aggregate
```
El reporte sera creado en:
```
//target/site/index.html
```
