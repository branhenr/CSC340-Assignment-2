package com.CSC340.assignment2;

public class DisneyCharacter {
    public String name;
    public int id;
    public String sourceMaterial;

    public DisneyCharacter(String name, int id, String sourceMaterial){
        this.name = name;
        this.id = id;
        this.sourceMaterial = sourceMaterial;
    }

    public String getName(){
        return name;
    }

    public String getSourceMaterial(){
        return sourceMaterial;
    }

    public int getid(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSourceMaterial(String sourceMaterial){
        this.sourceMaterial = sourceMaterial;
    }

    public void setId(int id){
        this.id = id;
    }
}
