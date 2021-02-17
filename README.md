# HibernateApp
A Hibernate/JPA application used in this [video](https://youtu.be/QJddHc41xrM). 

- If you want to setup a similar live template to the "jpa" template I use in the video, instructions on setting up live templates is [here](https://www.jetbrains.com/help/idea/using-live-templates.html). The "jpa" live template is configured with the following content:
```
EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("$PERSISTENCEUNIT$");
EntityManager entityManager = entityManagerFactory.createEntityManager();
EntityTransaction transaction = entityManager.getTransaction();
try {
    transaction.begin();
	
    $END$
	
    transaction.commit();
} finally {
    if(transaction.isActive()) {
        transaction.rollback();
    }
    entityManager.close();
    entityManagerFactory.close();
}
```
- If you're wondering how I setup the MySQL Docker container, I wrote my steps [here](https://daliashea.com/2021/01/06/configuring-a-jpa-application-with-a-mysql-docker-container/).

[![JetBrains team project](http://jb.gg/badges/team.svg)](https://confluence.jetbrains.com/display/ALL/JetBrains+on+GitHub)
