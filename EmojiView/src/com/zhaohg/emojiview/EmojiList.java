package com.zhaohg.emojiview;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class EmojiList {
	
	Context context;
	
	public EmojiList(Context context) {
		this.context = context;
	}
	
	public List<EmojiIcon> getIcons(int type) {
		long[] codeList = EmojiCodeMap.getCodeList(type);
		List<EmojiIcon> icons = new ArrayList<EmojiIcon>();
		for (long code : codeList) {
			int id = EmojiCodeMap.getDrawableID(code);
			icons.add(newIcon(code, id));
		}
		return icons;
	}
	
	protected EmojiIcon newIcon(long code, int id) {
		EmojiIconAdd icon = new EmojiIconAdd(context);
		icon.setEmojiCode(code);
		icon.setImageDrawable(this.context.getResources().getDrawable(id));
		return icon;
	}
}
