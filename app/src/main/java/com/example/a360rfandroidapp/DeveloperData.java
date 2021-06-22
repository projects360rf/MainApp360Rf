package com.example.a360rfandroidapp;

public class DeveloperData {

    private String name;
    private String post;
    private String image;
    private String mail;
    private String linkedin;

    public String getName() { return name;}

    public void setName(String name) { this.name = name ;}

    public String getPost() { return post;}

    public void setPost(String post) { this.post = post ;}

    public String getImage() { return image;}

    public void setImage(String image) { this.image = image ;}

    public String getMail() { return mail;}

    public void setMail(String mail) { this.mail = mail ;}

    public String getLinkedin() { return linkedin;}

    public void setLinkedin(String linkedin) { this.linkedin = linkedin;}

    public DeveloperData(String name, String post, String image,
                         String mail, String linkedin) {
        this.name = name;
        this.post = post;
        this.image = image;
        this.mail = mail;
        this.linkedin = linkedin;
    }

}
