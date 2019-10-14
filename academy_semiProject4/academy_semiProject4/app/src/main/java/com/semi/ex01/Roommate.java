package com.semi.ex01;

public class Roommate {

    private String id;
    private String matchTitle;
    private String matchPersonality;
    private String matchGender;
    private String matchRoomType;
    private String matchPrice;
    private String personCount;
    private String maxPersonCount;

    public String getPersonCount() {
        return personCount;
    }

    public void setPersonCount(String personCount) {
        this.personCount = personCount;
    }

    public String getMaxPersonCount() {
        return maxPersonCount;
    }

    public void setMaxPersonCount(String maxPersonCount) {
        this.maxPersonCount = maxPersonCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatchTitle() {
        return matchTitle;
    }

    public void setMatchTitle(String matchTitle) {
        this.matchTitle = matchTitle;
    }

    public String getMatchPersonality() {
        return matchPersonality;
    }

    public void setMatchPersonality(String matchPersonality) {
        this.matchPersonality = matchPersonality;
    }

    public String getMatchGender() {
        return matchGender;
    }

    public void setMatchGender(String matchGender) {
        this.matchGender = matchGender;
    }

    public String getMatchRoomType() {
        return matchRoomType;
    }

    public void setMatchRoomType(String matchRoomType) {
        this.matchRoomType = matchRoomType;
    }

    public String getMatchPrice() {
        return matchPrice;
    }

    public void setMatchPrice(String matchPrice) {
        this.matchPrice = matchPrice;
    }


    public Roommate(String id, String matchTitle, String matchPersonality, String matchGender, String matchRoomType, String matchPrice, String personCount, String maxPersonCount) {
        this.id = id;
        this.matchTitle = matchTitle;
        this.matchPersonality = matchPersonality;
        this.matchGender = matchGender;
        this.matchRoomType = matchRoomType;
        this.matchPrice = matchPrice;
        this.personCount = personCount;
        this.maxPersonCount = maxPersonCount;
    }
}

