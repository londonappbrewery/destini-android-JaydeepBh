package com.londonappbrewery.destini;


import java.io.Serializable;

public class Story implements Serializable {

    private static final long serialVersionUID = -856210544600464481L;
    private int mStoryId;
    private int mAnswerOne;
    private int mAnswerTwo;
    private Story mAnswerOneStory;
    private Story mAnswerTwoStory;

    public Story(int storyId, int answerOne, int answerTwo) {
        this.mStoryId = storyId;
        this.mAnswerOne = answerOne;
        this.mAnswerTwo = answerTwo;
        this.mAnswerOneStory = null;
        this.mAnswerTwoStory = null;
    }

    public int getStoryId() {
        return mStoryId;
    }

    public int getAnswerOne() {
        return mAnswerOne;
    }

    public int getAnswerTwo() {
        return mAnswerTwo;
    }

    public Story getAnswerOneStory() {
        return mAnswerOneStory;
    }

    public void setAnswerOneStory(Story answerOneStory) {
        mAnswerOneStory = answerOneStory;
    }

    public Story getAnswerTwoStory() {
        return mAnswerTwoStory;
    }

    public void setAnswerTwoStory(Story answerTwoStory) {
        mAnswerTwoStory = answerTwoStory;
    }

    public boolean hasAnswer() {
        if (mAnswerOne == 0 && mAnswerTwo == 0) {
            return false;
        }
        return true;
    }

    public boolean hasLinkedStory() {
        if (mAnswerOneStory == null && mAnswerTwoStory == null) {
            return false;
        }
        return true;
    }
}
