package com.londonappbrewery.destini;

import java.util.ArrayList;
import java.util.List;

public class StoryService {

    private static List<Story> mStoryList = new ArrayList<Story>();

    static {
        Story T1 = new Story(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2);
        mStoryList.add(T1);

        Story T2 = new Story(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2);
        mStoryList.add(T2);

        Story T3 = new Story(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2);
        mStoryList.add(T3);

        Story T4 = new Story(R.string.T4_End, 0, 0);
        mStoryList.add(T4);

        Story T5 = new Story(R.string.T5_End, 0, 0);
        mStoryList.add(T5);

        Story T6 = new Story(R.string.T6_End, 0, 0);
        mStoryList.add(T6);

        T1.setAnswerOneStory(T3);
        T1.setAnswerTwoStory(T2);

        T2.setAnswerOneStory(T3);
        T2.setAnswerTwoStory(T4);

        T3.setAnswerOneStory(T6);
        T3.setAnswerTwoStory(T5);
    }

    public Story getFirstStory() {
        return mStoryList.get(0);
    }

}
