package com.example.said.projecttwo;

public class User {
    String userName;
    int countOfImage,countOfGps;

    public User(String userName, int countOfImage, int countOfGps) {
        this.userName = userName;
        this.countOfImage = countOfImage;
        this.countOfGps = countOfGps;
    }

    public String getUserName() {
        return userName;
    }

    public int getCountOfImage() {
        return countOfImage;
    }

    public int getCountOfGps() {
        return countOfGps;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCountOfImage(int countOfImage) {
        this.countOfImage = countOfImage;
    }

    public void setCountOfGps(int countOfGps) {
        this.countOfGps = countOfGps;
    }
}
