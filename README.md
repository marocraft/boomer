[![Build Status](https://travis-ci.org/marocraft/boomer.svg?branch=develop)](https://travis-ci.org/marocraft/boomer) [![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=boomer&metric=alert_status)](https://sonarcloud.io/dashboard?id=-boomer) 

# boomer
Boomer is a JAVA based project aiming at providing details about remote exceptions (REST services) and offers the possibility to exception reconstruction at client side.

# Setting up the service

To setup the publishing starter, you've got to do the following:

## add the following dependencies to your pom.xml file:

```yaml
<dependencies>
  <!-- ... -->
    <dependency>
       <groupId>ma.craft.boomer</groupId>
       <artifactId>Boomer</artifactId>
       <version>1.0.2-SNAPSHOT</version>
    </dependency>
</dependencies>
```

## Details about remote exceptions
If you want to get a lot of information about yours remote exceptions , you  must just add  the annotation "@Boomer" , as the following example :

```java
  @Boomer
  public class Starter {
     .... </>
  }
```

As a conclusion, an user will be able  to get more information about your exceptions and  offers the possibility to exception reconstruction at client side.
