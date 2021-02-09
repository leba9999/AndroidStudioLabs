package com.example.lab6_1;

public class President {
    private String name;
    private int startYear;
    private int endYear;
    private String description;

    public President() {
        this.name = "Unknown";
        this.startYear = 0;
        this.endYear = 0;
        this.description = "Unknown";
    }

    public President(String name, int startYear, int endYear, String description) {
        this.name = name;
        this.startYear = startYear;
        this.endYear = endYear;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getStartYear() {
        return this.startYear;
    }

    public int getEndYear() {
        return this.endYear;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
