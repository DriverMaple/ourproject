package com.mooc.entity;

public class User {
    private Long userId;

    private Long telephone;

    private String password;

    private Byte sex;

    private Long idNumber;

    private String name;

    private Byte type;

    private Long dLicense;

    private Long fLicense;

    private String place;

    private Float aveScore;

    public User(Long userId, Long telephone, String password, Byte sex, Long idNumber, String name, Byte type, Long dLicense, Long fLicense, String place, Float aveScore) {
        this.userId = userId;
        this.telephone = telephone;
        this.password = password;
        this.sex = sex;
        this.idNumber = idNumber;
        this.name = name;
        this.type = type;
        this.dLicense = dLicense;
        this.fLicense = fLicense;
        this.place = place;
        this.aveScore = aveScore;
    }

    public User() {
        super();
        userId = null;
        telephone = null;
        password = null;
        sex = null;
        idNumber = null;
        name = null;
        type = null;
        dLicense = null;
        fLicense = null;
        place = null;
        aveScore = null;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Long getdLicense() {
        return dLicense;
    }

    public void setdLicense(Long dLicense) {
        this.dLicense = dLicense;
    }

    public Long getfLicense() {
        return fLicense;
    }

    public void setfLicense(Long fLicense) {
        this.fLicense = fLicense;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public Float getAveScore() {
        return aveScore;
    }

    public void setAveScore(Float aveScore) {
        this.aveScore = aveScore;
    }
}