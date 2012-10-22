WEB SERVICE
===========


This is a project of M1 ALMA at the university of Nantes.
We have to create a web application for Nantes.


TODO
----

* See how to place markers according to the distance for the PMV. (Thanatos21 & Niiner)
* JUnit test.



INFO
----

* CSV library for JAVA : http://opencsv.sourceforge.net/#where-can-I-get-it
* jdom-2.0.3 to download and add to libraries' project : http://www.jdom.org/downloads/index.html
* Authentification key for our application on open data nantes : 4XTL4M0FTTASDFQ
* fixed schedule bug with glassfish : set server.ejb-container.property.disable-nonportable-jndi-names="true" on ./asadmin
* Dump SQL Table : shell> mysqldump --user=****** --password=****** -A > /Chemin/Vers/fichier_dump.SQL
* restore ot : shell> mysql --user=****** --password=****** db_nom < /Chemin/Vers/fichier_dump.SQL


DONE
----

* Static html interface for the application
* Software structure established
* Create the database for application (create a table for PMV). (bmael)
* Create a method for upload the open data into our database. (bmael)
* Upgrade loading of PMV in our database. New package in utilities to do this. (bmael)
* See how it's possible to upgrade the importation to execute it once a day. (bmael)
* Example of a servlet with code injection : display all the PMV into our database using the PMVController. (bmael)
* Execute the importation of PMV into our database at a given date. (bmael)
* Create a table in our database to have all itinerary covered by PMVs. (bmael)
* Complete the PMV model to have itineraries displayed by a PMV. (bmael)
* Link ids in database.(bmael)
* XMLParser realized. (Niiner)
* Create table for statistic into our database. (niiner)
* Fixe a bug for Schedules in periodic import. (bmael)
* Method into StatsPMVController to retrieves all itineraries between 2 dates with a given id. (bmael)
* Creating all classes for JUnit test. (bmael)
* Retrieve the displayed times for itineraries displayed by a PMV. (Thanatos21).
* Larger point in the XYLineChart. (bmael)
* Problem with schedules fixed. (bmael)


