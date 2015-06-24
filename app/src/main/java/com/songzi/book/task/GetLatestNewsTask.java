package com.songzi.book.task;

import java.io.IOException;

import android.content.Context;

import com.songzi.book.Constants;
import com.songzi.book.db.NewsDataSource;
import com.songzi.book.entity.NewsListEntity;
import com.songzi.book.util.GsonUtils;
import com.songzi.book.util.ListUtils;
import com.songzi.book.util.BookUtils;

/**
 * 类说明： 	从服务器下载最新新闻列表，Task
 * 
 * @date 	2014-9-15
 * @version 1.0
 */
public class GetLatestNewsTask extends BaseGetNewsTask {

	public GetLatestNewsTask(Context context, ResponseListener listener) {
		super(context, listener);
	}
	
	@Override
	protected NewsListEntity doInBackground(String... params) {

		String oldContent = null, newContent = null;

		String date = null;

		NewsListEntity newsListEntity = null;
		
		try {
			newContent = getUrl(Constants.Url.URL_LATEST);
			newsListEntity = (NewsListEntity) GsonUtils.getEntity(newContent, NewsListEntity.class);
			
			date = newsListEntity != null ? newsListEntity.date : null;
			
			oldContent = ((NewsDataSource) getDataSource()).getContent(date);
			
			isRefreshSuccess = !ListUtils.isEmpty(newsListEntity.stories);	
		} catch (IOException e) {
			e.printStackTrace();
			
			this.isRefreshSuccess = false;
			this.mException = e;
		} catch (Exception e) {
			e.printStackTrace();

			this.isRefreshSuccess = false;
			this.mException = e;
		}
		
		isContentSame = checkIsContentSame(oldContent, newContent);
		
		if (isRefreshSuccess && !isContentSame) {
			((NewsDataSource) getDataSource()).insertOrUpdateNewsList(Constants.NEWS_LIST, date, newContent);
		}
		
		if (newsListEntity != null) {
			BookUtils.setReadStatus4NewsList(newsListEntity.stories);
		}
		
		return newsListEntity;
	}
}