package design.ivisionblog.apps.reviewdialoglibrary;

/**
 * Created by Shivasurya S on 13/01/18.
 */
public interface FeedBackActionsListeners
{
    void onSuccess(FeedBackDialog dialog);
    void onFailure(FeedBackDialog dialog);
    void onAmbiguity(FeedBackDialog dialog);
}
