# Feedback Dialog for Android   
[ ![Download](https://api.bintray.com/packages/shivasurya/maven/feedback-dialog/images/download.svg) ](https://bintray.com/shivasurya/maven/feedback-dialog/_latestVersion)    [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

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
```java
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

### Feedback Dialog API 

You can check below some of the exposed API methods to control the Dialog apperance and actions. Hereby I'll try to maintain backward compatibility for Minor version and patch version and probably breaking changes in Major version changes ( refer semver )

1. ```setIcon(@DrawableRes int mIcon)``` - set Drawable Image at top of the Dialog as Icon. <br />
2. ```setTitle(@StringRes int mTitle)``` -  set Title or Brand Name for the Feedback Dialog
3. ```setDescription(@StringRes int mDescription)``` - set Description or Additional text for Feedback Dialog
4. ```setPositiveFeedbackText(@StringRes int mPositiveFeedbackText)``` - set Positive Feedback button text
5. ```setNegativeFeedbackText(@StringRes int mNegativeFeedbackText)``` - set Negative Feedback button text
6. ```setAmbiguityFeedbackText(@StringRes int mAmbiguityFeedbackText``` - set Ambiguity Feedback button text
7. ```setPositiveFeedbackIcon(@DrawableRes int mPositiveFeedbackIcon)``` - set Positive Feedback button Icon as drawable resource
8. ```setNegativeFeedbackIcon(@DrawableRes int mNegativeFeedbackIcon)``` - set Negative Feedback button Icon as drawable resource
9. ```setAmbiguityFeedbackIcon(@DrawableRes int mAmbiguityFeedbackIcon)``` - set Ambiguity Feedback button Icon as drawable resource
10. ```setBackgroundColor(@ColorRes int mBackgroundColor)``` - set Feedback Dialog background color
11. ```setIconColor(@ColorRes int mIconColor)``` - set Title and Action Icon colors
12. ```setReviewQuestion(int mReviewQuestion)``` - set Questionable message to end-user which is shown in Dialog
14. ```setOnReviewClickListener(FeedBackActionsListeners reviewActionsListeners)``` - set Feedback Action listeners which implements action listeners callback.
15. ```dismiss()``` - dismiss the active Feedback Dialog

API's which are added or removed will be updated in the above list. If possible, there will be seperate documentation site with examples in upcoming revisions.

### RoadMap

* Animating Popup style for dialog Icon and adding shadow to it.
* Swipe left for next review similar to Google Maps reviews.
* Animating Feedback dialog while opening and closing.


### Inspiration

As Active `Google Maps reviewer`, usually I would answer review questions via Google Maps for Android. They have similar but better dialog to collect information and facts about the places with lot of animations like swipe, popup. Inspired from those user interface just thought to develop a component for collecting feedback without filling-up huge forms or monotonous UI.

### Contribution and Issues

We love contributions from everyone.
By participating in this project,
you agree to abide by the thoughtbot [code of conduct].

  [code of conduct]: https://thoughtbot.com/open-source-code-of-conduct

We expect everyone to follow the code of conduct
anywhere in thoughtbot's project codebases,
issue trackers, chatrooms, and mailing lists.

### Contributing Code

Make your change, with new passing tests. Follow the [style guide][style].

  [style]: https://github.com/thoughtbot/guides/tree/master/style

Push to your fork. Write a [good commit message][commit]. Submit a pull request.

  [commit]: http://tbaggery.com/2008/04/19/a-note-about-git-commit-messages.html

Others will give constructive feedback.
This is a time for discussion and improvements,
and making the necessary changes will be required before we can merge the contribution.

### License
[Apache-2.0](https://github.com/shivasurya/FeedbackDialog/blob/master/LICENSE)
