# TheElectionMachineRest

**This is the second part of The Election Machine project that uses REST**  
[Here](https://github.com/jenhakk/TheElectionMachine) you can check the first part.

Team: [Jenna Hakkarainen](https://github.com/jenhakk), [Amanda Karjalainen](https://github.com/amakarj), [Anna-Maria Palm](https://github.com/A-d-f)

## Task

Our task was to continue with The Election Machine using **REST** and **JPA**.  
In the first part we already used **JSP, database (MySQL) and HTML/CSS**. 

In the previous version there were features for
 * the voter to find suitable candidates
 * the candidate to answer questions and edit/delete them

For the second part we wanted to add features for **the admin side**. In the task description there was asked to do only one feature but we wanted to add two.
New features were:

 * Admin can add, edit and delete questions 
 * Admin can add, edit and delete candidates
 
All data is saved in **a local database** and it is handled with **JPA**. The methods for JPA are in `Daojpa.java` and they are called from `Rest.java`. Data is transferred between the REST and JSP files with **RequestDispatcher**.

We added few extra features e.g.
 * login for the admin using **AuthFilter** 
 * pop-up window when deleting data
 * adding commenting opportunity for the voter when answering questions

## Conclusion
The project was fun to work with and we learned a lot. It was demanding and it helped develop our problem-solving skills. We only had few weeks to work with and there was a much to take in. The fact that we had to connect the first part of the project with this one added some extra challenge.  
For example, we hadn’t thought how deleting questions and candidates would affect the functionality. We also had to re-create the database because we had used two primary keys instead of foreign keys.

All in all, the second part came together quickly after we figured out how the data is being transferred. We succeeded to create functioning site and added few extra features like:
 * adding candidate’s picture from local machine/project’s folder 
 * admin login 
 * *customized* confirmation window for deleting  
 

If we had more time we would have wanted to create filtering for the candidates for example by party or municipality.
