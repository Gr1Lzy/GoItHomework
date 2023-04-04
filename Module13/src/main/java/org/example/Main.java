package org.example;


import org.example.module13_1.JSONFunctional;
import org.example.module13_2.FileWriter;
import org.example.module13_3.TaskChecker;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(JSONFunctional.getAllUsers("https://jsonplaceholder.typicode.com/users")
                + "\n-------------------------------------------------------");
        System.out.println("User added: \n" + JSONFunctional.createUser()
                + "\n-------------------------------------------------------");
        System.out.println("User updated: \n" + JSONFunctional.updateUser(1)
                + "\n-------------------------------------------------------");
        System.out.println("DELETED code: " + JSONFunctional.deleteUser(1)
                + "\n-------------------------------------------------------");
        System.out.println("User by id: " + JSONFunctional.getUserByID(2)
                + "\n-------------------------------------------------------");
        System.out.println("User by username: " + JSONFunctional.getUserByUsername("Maxime_Nienow")
                + "\n-------------------------------------------------------");

        int userID = 3;

        FileWriter.writeCommentsToFile(userID, FileWriter.getLastPostIdByUserId(userID));
        System.out.println("Write in file done!"
                + "\n-------------------------------------------------------");
        System.out.println("All tasks that uncompleted: \n" + TaskChecker.getUncompletedTasks(userID)
                + "\n-------------------------------------------------------");
    }
}