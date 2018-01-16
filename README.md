# Feedback Dialog for Android   [ ![Download](https://api.bintray.com/packages/shivasurya/maven/feedback-dialog/images/download.svg) ](https://bintray.com/shivasurya/maven/feedback-dialog/_latestVersion)
An Interactive Feedback Dialog for Android inspired from Google Maps Review section


<p align="center">
<img src="/screenshots/logo.png?raw=true" width="200" >
</p>

> It's very important to have a feedback loop, where you're constantly thinking about what you've done and how you could be doing it better. - Elon Musk


Getting feedback from your customers, prospects is the most important task for developing and moving a product. Getting inspired from Google Maps Review section, I've compiled and crafted this library to make sure this utility will be helpful to get feedback from customers easily without any monotonous forms fillup and with less input.

### Few usecases
|<img src="/screenshots/screenshot1.png?raw=true" width="400" >| <img src="/screenshots/screenshot2.png?raw=true" width="400" > 
|--|--|
| <img src="/screenshots/screenshot3.png?raw=true" width="400" >| <img src="/screenshots/screenshot4.png?raw=true" width="400" >|

### Install dependency
`compile 'design.ivisionblog.apps:feedback-dialog:0.0.1-alpha'`

### Getting Started

As simple as AlertDialog API,
```
          FeedBackDialog mDialog = new FeedBackDialog(MainActivity.this)
                .setBackgroundColor(R.color.bgcolor)
                .setIcon(R.drawable.brand_icon)
                .setIconColor(R.color.brand_color)
                .setTitle(R.string.brand_name)
                .setDescription(R.string.brand_description)
                .setReviewQuestion(R.string.customer_review_question)
                .setPositiveFeedbackText(R.string.positive_feedback_text)
                .setNegativeFeedbackText(R.string.negative_feedback_text)
                .setAmbiguityFeedbackText(R.string.ambiguity_feedback_text)
                .setOnReviewClickListener(new FeedBackActionsListeners() {
                    @Override
                    public void onPositiveFeedback(FeedBackDialog dialog) {
                        Log.d(LOG_TAG,"positive feedback callback");
                        dialog.dismiss();
                    }

                    @Override
                    public void onNegativeFeedback(FeedBackDialog dialog) {
                        Log.d(LOG_TAG,"negative feedback callback");
                        dialog.dismiss();
                    }

                    @Override
                    public void onAmbiguityFeedback(FeedBackDialog dialog) {
                        Log.d(LOG_TAG,"ambiguity feedback callback");
                        dialog.dismiss();
                    }

                    @Override
                    public void onCancelListener(DialogInterface dialog) {
                        Log.d(LOG_TAG,"feedback dialog cancel listener callback");
                        dialog.dismiss();
                    }
                })
                .show();  // Finally don't forget to call show()
```
