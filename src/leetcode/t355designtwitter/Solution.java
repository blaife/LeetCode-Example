package leetcode.t355designtwitter;

import java.util.*;

/**
 * @author Blaife
 * @description 355 - 设计推特
 * @data 2020/4/13 15:56
 * 题意：
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * 示例:
 *
 * Twitter twitter = new Twitter();
 *
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 *
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 *
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 *
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 */
public class Solution {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.unfollow(1, 1);
        System.out.println(twitter.getNewsFeed(1));
    }
}

    /**
     * 功能描述: 设计推特 击败10%
     *      使用 ArrayList 作为tweet存储空间 （这一部分是很耗费效率的）
     *      使用 Map<Set<Integer>> 作为关注列表
     * @author: Blaife
     * @date: 2020/4/13 17:02
     */
    class Twitter {

        /** 推文列表 **/
        List<String> tweetsAllList = new ArrayList<>();

        /** 关注列表 **/
        Map<Integer, HashSet<Integer>> attentionMap = new HashMap<>();

        /** 在此初始化您的数据结构。 */
        public Twitter() {
    }

    /** 撰写新的推文。 */
    public void postTweet(int userId, int tweetId) {
        tweetsAllList.add(userId + "," + tweetId);
    }

    /** 检索用户新闻提要中的10个最新的tweet ID。新闻订阅源中的每个项目都必须由用户关注的用户或用户本人发布。必须按从最新到最近的顺序排列推文。 */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweetsList = new ArrayList<>();

        // 关注人员set集合
        Set<Integer> followees = new HashSet<>();
        followees.add(userId);

        // 得到关注者的推文
        if (attentionMap.get(userId) != null) {
            followees.addAll(attentionMap.get(userId));
        }

        for (int i = tweetsAllList.size()-1; i >= 0; i--) {
            String[] tweetArray = tweetsAllList.get(i).split(",");
            if (followees.contains(Integer.parseInt(tweetArray[0]))) {
                tweetsList.add(Integer.parseInt(tweetArray[1]));
                if (tweetsList.size() == 10) {
                    break;
                }
            }
        }
        return tweetsList;
    }

    /** 关注者关注关注者。如果操作无效，则应为空操作。 */
    public void follow(int followerId, int followeeId) {
        if (attentionMap.get(followerId) != null) {
            attentionMap.get(followerId).add(followeeId);
        } else {
            HashSet<Integer> followeeSet = new HashSet<>();
            followeeSet.add(followeeId);
            attentionMap.put(followerId, followeeSet);
        }
    }

    /** 关注者取消关注关注者。如果操作无效，则应为空操作。 **/
    public void unfollow(int followerId, int followeeId) {
        if (attentionMap.get(followerId) != null) {
            attentionMap.get(followerId).remove(followeeId);
        }
    }
}
