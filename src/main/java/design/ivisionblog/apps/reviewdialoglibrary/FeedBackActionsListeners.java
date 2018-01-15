package design.ivisionblog.apps.reviewdialoglibrary;

import android.content.DialogInterface;

/**
 * Created by Shivasurya S on 13/01/18.
 */
public interface FeedBackActionsListeners
{
    void onPositiveFeedback(FeedBackDialog dialog);
    void onNegativeFeedback(FeedBackDialog dialog);
    void onAmbiguityFeedback(FeedBackDialog dialog);
    void onCancelListener(DialogInterface dialog);
}
