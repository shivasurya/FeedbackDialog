package design.ivisionblog.apps.reviewdialoglibrary;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class FeedBackDialog {

    private Context mContext;
    @DrawableRes
    private int mIcon;

    @StringRes
    private int mTitle;

    @StringRes
    private int mDescription;

    @StringRes
    private int mReviewQuestion;


    private ImageView   titleImageView;
    private TextView    titleTextView;
    private TextView    descriptionTextView;
    private TextView    reviewQuestionTextView;

    private LinearLayout positiveFeedbackLayout;
    private LinearLayout negativeFeedbackLayout;
    private LinearLayout ambiguityFeedbackLayout;


    private Dialog mDialog;

    private FeedBackActionsListeners mReviewActionsListener;

    public FeedBackDialog(Context mContext)
    {
        this.mContext = mContext;

        mDialog = new Dialog(mContext,R.style.Theme_Dialog);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.review_dialog_base);
    }

    private void initiateAllViews()
    {
        titleImageView          = mDialog.findViewById(R.id.review_icon);
        titleTextView           = mDialog.findViewById(R.id.review_title);
        descriptionTextView     = mDialog.findViewById(R.id.review_description);
        reviewQuestionTextView  = mDialog.findViewById(R.id.review_questions);
    }

    private void initiateListeners()
    {
        positiveFeedbackLayout = mDialog.findViewById(R.id.postive_feedback_layout);
        negativeFeedbackLayout = mDialog.findViewById(R.id.negative_feedback_layout);
        ambiguityFeedbackLayout = mDialog.findViewById(R.id.ambiguity_feedback_layout);

        positiveFeedbackLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                onPositiveFeedbackClicked(v);
            }
        });

        negativeFeedbackLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNegativeFeedbackClicked(v);
            }
        });

        ambiguityFeedbackLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAmbiguityFeedbackClicked(v);
            }
        });
    }

    public FeedBackDialog show()
    {
        if(mDialog != null && mContext != null)
        {
            initiateAllViews();
            initiateListeners();

            LayerDrawable layerDrawable = (LayerDrawable) mContext.getResources().getDrawable(R.drawable.round_icon);
            layerDrawable.setDrawableByLayerId(R.id.drawable_image,mContext.getResources().getDrawable(this.mIcon));

            titleImageView.setImageDrawable(layerDrawable);
            titleTextView.setText(mContext.getString(this.mTitle));
            descriptionTextView.setText(mContext.getString(this.mDescription));
            reviewQuestionTextView.setText(mContext.getString(this.mReviewQuestion));

            mDialog.show();
        }
        return this;
    }

    public int getTitleIcon()
    {
        return mIcon;
    }

    public FeedBackDialog setIcon(int mIcon)
    {
        this.mIcon =  mIcon;
        return this;
    }

    public int getTitle()
    {
        return mTitle;
    }

    public FeedBackDialog setTitle(int mTitle)
    {
        this.mTitle = mTitle;
       return this;
    }

    public int getDescription()
    {
        return mDescription;
    }

    public FeedBackDialog setDescription(int mDescription)
    {
        this.mDescription = mDescription;
        return this;
    }

    public int getReviewQuestion()
    {
        return mReviewQuestion;
    }

    public FeedBackDialog setReviewQuestion(int mReviewQuestion)
    {
        this.mReviewQuestion = mReviewQuestion;
        return this;
    }

    public FeedBackDialog setOnReviewClickListener(FeedBackActionsListeners reviewActionsListeners)
    {
        this.mReviewActionsListener = reviewActionsListeners;
        return this;
    }

    public void dismiss()
    {
        if(mDialog != null)
        {
            mDialog.dismiss();
        }
    }

    public void onPositiveFeedbackClicked(View view)
    {
        if(mReviewActionsListener != null)
        {
            mReviewActionsListener.onSuccess();
        }
    }

    public void onNegativeFeedbackClicked(View view)
    {
        if(mReviewActionsListener != null)
        {
            mReviewActionsListener.onFailure();
        }
    }

    public void onAmbiguityFeedbackClicked(View view)
    {
        if(mReviewActionsListener != null)
        {
            mReviewActionsListener.onAmbiguity();
        }
    }
}
