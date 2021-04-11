
<h3 align="center">Data Migration Project</h3>

  <p align="center">
    Transferring data from a .cvs file to a sql database
    <br />
    <a href="https://github.com/pkpatch/DatamigrationProject"><strong>Explore the docs »</strong></a>
    <br />
    <br />
  </p>

<!-- TABLE OF CONTENTS -->
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    <li><a href="#process">Process</a>
    <li><a href="#future-work">Future Work</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>

<!-- ABOUT THE PROJECT -->
## About The Project

This project was interesting in terms of understanding the process as well as different implementations availiable and comparing the fastest. In understanding the database insertion process, I was able to competantly produce a fully functional program with a great insight to how it performs under different sized files.

### Built With

* IntelliJ IDEA 2020.3.2
* JDK 11
* jUnit
* log4j
* Git

<!-- Process -->
## Process

With the use of multithreading, I have been able to design a program that will take 2 files of different sizes to read, extract and validate the data, to then insert into the SQL Database.
 
 My approach:
 
 My FileReader class begins by using the Filereader to read the file from the input file location, the buffered reader then reads the file line by line. 
 This then enters a while loop, each string line is then split at each comma into an array of String data. 
 The data is then validated to ensure the correct data-types and values are within certain limits.
 The valid data is then used to create an Employee object and entered into a Hashmap with the Employee Id being used for the key.
 
 Once the file has been read, the hash map of objects are sent to the Employee manager class with the tablename. 
 The table is created and the map is passed into the insert method.
 Using an advanced for loop, each object is taken from the key, then using the appropiate getter methods, the data is placed into the prepared statement and added to the batch.
 Once the loop finishes, the statement is executed and the data is inserted into the table in the database.
 
 I decided to use a hashmap to ensure there were no duplicate rows entered. 
 I have used 'log4j' to keep track of events throughout the program to ensure the user is aware of any invalid values or exceptions that occured.
 To understand how the performance of the process differs given the number of threads, I record the time elapsed at different stages: when the file is read, when the data is inserted into the database and how long for the entire program to complete.
 
 ## Future Work
 
 - User Interface
 - Further work with threads to speed up the process
 - CRUD features

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.

<!-- CONTACT -->
## Contact

Patrick Walsh - www.linkedin.com/in/patrick-walsh-jsdet - pwalsh@spartaglobal.com

Project Link: [https://github.com/pkpatch/DatamigrationProject](https://github.com/pkpatch/DatamigrationProject)


