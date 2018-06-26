package by.it.kashayed.Project.CRUD;


import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        CRUD crud = new CRUD();
        User nuser = new User(0,"ss","ss@mail.ru","paaassa","name",1);
        if(crud.create(nuser)){
            System.out.println("create"+nuser);
        }
        if(crud.read(nuser.getId())!=null){
            System.out.println("read"+nuser);
        }
        nuser.setName("Pupkin");
        if(crud.update(nuser)){
            System.out.println("Update"+nuser);
        }
        if(crud.delete(nuser)){
            System.out.println("Delete"+nuser);
        }

    }
}
