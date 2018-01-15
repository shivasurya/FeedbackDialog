package design.ivisionblog.apps.reviewdialoglibrary;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class FeedBackDialog {

    private Context mContext;

    @DrawableRes
    private int mIcon;

    @ColorRes
    private int mIconColor;

    @StringRes
    private int mTitle;

    @DrawableRes
    private int mBackgroundColor;

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
    private LinearLayout feedbackBodyLayout;

    private TextView positiveFeedbackTextView;
    private TextView negativeFeedbackTextView;
    private TextView ambiguityFeedbackTextView;

    private ImageView positiveFeedbackIconView;
    private ImageView negativeFeedbackIconView;
    private ImageView ambiguityFeedbackIconView;


    @StringRes
    private int mPositiveFeedbackText;

    @DrawableRes
    private int mPositiveFeedbackIcon;

    @StringRes
    private int mNegativeFeedbackText;

    @DrawableRes
    private int mNegativeFeedbackIcon;

    @StringRes
    private int mAmbiguityFeedbackText;

    @DrawableRes
    private int mAmbiguityFeedbackIcon;




    private Dialog mDialog;

    private FeedBackActionsListeners mReviewActionsListener;

    public FeedBackDialog(Context mContext)
    {
        this.mContext = mContext;

        mDialog = new Dialog(mContext,R.style.FeedbackDialog_Theme_Dialog);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.review_dialog_base);

        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
        {
            int width = (int) (mContext.getResources().getDisplayMetrics().widthPixels * 0.90);
            int height = (int) (mContext.getResources().getDisplayMetrics().heightPixels * 0.50);

            if (mDialog.getWindow() != null) {
                mDialog.getWindow().setLayout(width, height);
            }
        }
    }

    private void initiateAllViews()
    {
        titleImageView          = mDialog.findViewById(R.id.review_icon);
        titleTextView           = mDialog.findViewById(R.id.review_title);
        descriptionTextView     = mDialog.findViewById(R.id.review_description);
        reviewQuestionTextView  = mDialog.findViewById(R.id.review_questions);

        feedbackBodyLayout      = mDialog.findViewById(R.id.feedback_body_layout);

        positiveFeedbackLayout = mDialog.findViewById(R.id.postive_feedback_layout);
        negativeFeedbackLayout = mDialog.findViewById(R.id.negative_feedback_layout);
        ambiguityFeedbackLayout = mDialog.findViewById(R.id.ambiguity_feedback_layout);


        positiveFeedbackTextView = mDialog.findViewById(R.id.positive_feedback_text);
        negativeFeedbackTextView = mDialog.findViewById(R.id.negative_feedback_text);
        ambiguityFeedbackTextView = mDialog.findViewById(R.id.ambiguity_feedback_text);

        positiveFeedbackIconView = mDialog.findViewById(R.id.postive_feedback_icon);
        negativeFeedbackIconView = mDialog.findViewById(R.id.negative_feedback_icon);
        ambiguityFeedbackIconView = mDialog.findViewById(R.id.ambiguity_feedback_icon);
    }

    private void initiateListeners()
    {

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

            LayerDrawable layerDrawable = (LayerDrawable) mContext.getResources().getDrawable(R.drawable.reviewdialog_round_icon);
            GradientDrawable gradientDrawable = (GradientDrawable) layerDrawable.findDrawableByLayerId(R.id.round_background);
            gradientDrawable.setColor(Color.parseColor("#FFFFFF"));
            layerDrawable.setDrawableByLayerId(R.id.round_background,gradientDrawable);

            Drawable drawable = mContext.getResources().getDrawable(this.mIcon);
            Drawable wrappedDrawable = DrawableCompat.wrap(drawable);

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            {
                DrawableCompat.setTint(drawable.mutate(), mContext.getResources().getColor(mIconColor));
            }
            else
            {
                drawable.setColorFilter(mContext.getResources().getColor(mIconColor), PorterDuff.Mode.SRC_IN);
            }


            layerDrawable.setDrawableByLayerId(R.id.drawable_image,drawable);

            titleImageView.setImageDrawable(layerDrawable);
            titleTextView.setText(mContext.getString(this.mTitle));
            descriptionTextView.setText(mContext.getString(this.mDescription));
            reviewQuestionTextView.setText(mContext.getString(this.mReviewQuestion));

            positiveFeedbackTextView.setText(this.mPositiveFeedbackText);
            positiveFeedbackIconView.setImageResource(this.mPositiveFeedbackIcon);
            positiveFeedbackIconView.setColorFilter(mContext.getResources().getColor(mIconColor));

            negativeFeedbackTextView.setText(this.mNegativeFeedbackText);
            negativeFeedbackIconView.setImageResource(this.mNegativeFeedbackIcon);
            negativeFeedbackIconView.setColorFilter(mContext.getResources().getColor(mIconColor));

            ambiguityFeedbackTextView.setText(this.mAmbiguityFeedbackText);
            ambiguityFeedbackIconView.setImageResource(this.mAmbiguityFeedbackIcon);
            ambiguityFeedbackIconView.setColorFilter(mContext.getResources().getColor(mIconColor));

            feedbackBodyLayout.setBackgroundResource(this.mBackgroundColor);

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

    public int getPositiveFeedbackText()
    {
        return mPositiveFeedbackText;
    }

    public FeedBackDialog setPositiveFeedbackText(@StringRes int mPositiveFeedbackText)
    {
        this.mPositiveFeedbackText = mPositiveFeedbackText;
        return this;
    }

    public int getPositiveFeedbackIcon()
    {
        return mPositiveFeedbackIcon;
    }

    public FeedBackDialog setPositiveFeedbackIcon(@DrawableRes int mPositiveFeedbackIcon)
    {
        this.mPositiveFeedbackIcon = mPositiveFeedbackIcon;
        return this;
    }

    public int getNegativeFeedbackText()
    {
        return mNegativeFeedbackText;
    }

    public FeedBackDialog setNegativeFeedbackText(@StringRes int mNegativeFeedbackText)
    {
        this.mNegativeFeedbackText = mNegativeFeedbackText;
        return this;
    }

    public int getNegativeFeedbackIcon()
    {
        return mNegativeFeedbackIcon;
    }

    public FeedBackDialog setNegativeFeedbackIcon(@DrawableRes int mNegativeFeedbackIcon)
    {
        this.mNegativeFeedbackIcon = mNegativeFeedbackIcon;
        return this;
    }

    public int getAmbiguityFeedbackText()
    {
        return mAmbiguityFeedbackText;
    }

    public FeedBackDialog setAmbiguityFeedbackText(@StringRes int mAmbiguityFeedbackText)
    {
        this.mAmbiguityFeedbackText = mAmbiguityFeedbackText;
        return this;
    }

    public int getAmbiguityFeedbackIcon()
    {
        return mAmbiguityFeedbackIcon;
    }

    public FeedBackDialog setAmbiguityFeedbackIcon(@DrawableRes int mAmbiguityFeedbackIcon)
    {
        this.mAmbiguityFeedbackIcon = mAmbiguityFeedbackIcon;
        return this;
    }

    public int getBackgroundColor() {
        return mBackgroundColor;
    }

    public FeedBackDialog setBackgroundColor(@ColorRes int mBackgroundColor) {
        this.mBackgroundColor = mBackgroundColor;
        return this;
    }

    public int getIconColor()
    {
        return mIconColor;
    }

    public FeedBackDialog setIconColor(@ColorRes int mIconColor)
    {
        this.mIconColor = mIconColor;
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

    private void onPositiveFeedbackClicked(View view)
    {
        if(mReviewActionsListener != null)
        {
            mReviewActionsListener.onPositiveFeedback(this);
        }
    }

    private void onNegativeFeedbackClicked(View view)
    {
        if(mReviewActionsListener != null)
        {
            mReviewActionsListener.onNegativeFeedback(this);
        }
    }

    private void onAmbiguityFeedbackClicked(View view)
    {
        if(mReviewActionsListener != null)
        {
            mReviewActionsListener.onAmbiguityFeedback(this);
        }
    }
}
