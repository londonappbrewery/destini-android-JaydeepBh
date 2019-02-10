package com.londonappbrewery.destini;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final private static String KEY_ACTIVE_STORY = "ActiveStory";
    private Button buttonTop;
    private Button buttonBottom;
    private TextView textViewStory;
    final private StoryService mStoryService = new StoryService();
    private Story mActiveStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mActiveStory = (Story) savedInstanceState.getSerializable(KEY_ACTIVE_STORY);
        }

        buttonTop = findViewById(R.id.buttonTop);
        buttonBottom = findViewById(R.id.buttonBottom);
        textViewStory = findViewById(R.id.storyTextView);
        updateStory();
        buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActiveStory = mActiveStory.getAnswerOneStory();
                updateStory();
            }
        });
        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActiveStory = mActiveStory.getAnswerTwoStory();
                updateStory();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY_ACTIVE_STORY, mActiveStory);
    }

    private void updateStory() {
        if (mActiveStory == null) {
            mActiveStory = mStoryService.getFirstStory();
        }
        textViewStory.setText(mActiveStory.getStoryId());
        if (mActiveStory.hasAnswer()) {
            buttonTop.setText(mActiveStory.getAnswerOne());
            buttonBottom.setText(mActiveStory.getAnswerTwo());
            buttonBottom.setVisibility(View.VISIBLE);
        } else {
            buttonTop.setText(R.string.button_restart_text);
            buttonBottom.setVisibility(View.GONE);
        }
    }
}
