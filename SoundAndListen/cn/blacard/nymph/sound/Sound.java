package cn.blacard.nymph.sound;

import java.util.ArrayList;
import java.util.List;

import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechSynthesizer;
import com.iflytek.cloud.speech.SpeechUtility;
import com.iflytek.cloud.speech.SynthesizerListener;

import cn.blacard.nymph.sound.constant.Voice;

/**
 * 修改过后的语音类。可能还不够稳定，
 * 后期继续补充，稳定，
 * 
 * @author Blacard
 * @联系方式  邮箱：blacard@163.com <br/> 手机：18037170703
 * @Create 2016年9月25日 下午11:08:50
 */
public class Sound {
	//播放器是否是空闲状态
	private static boolean isFree = true;
	//要说的话都在这个列表，说一个删一个
	private static List<TalkInfo> list = new ArrayList<TalkInfo>();
	
	private static String voice = Voice.小婧;
	/**
	 * 对外公开的接口
	 * @author Blacard
	 * @create 2016年9月25日 下午11:06:15
	 * @param word
	 */
	public static void speak(String word){
		speak(word,voice);
	}
	public static void speak(String word,String v){
		if(list.size()==0) listener();
		list.add(new TalkInfo(word,v));
	}
	
	/**
	 * 监听 list
	 * 一个一个播放
	 * @author Blacard
	 * @create 2016年9月25日 下午11:07:25
	 */
	private static void listener(){
		new Thread(){
			public void run(){
				while(true){
					try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
					if(list!=null&&list.size()>0){
						if(isFree){
							play(list.get(0));
							list.remove(0);
						}
					}else{
						return;
					}
				}
			}
		}.start();
	}
	
	private static void play(TalkInfo info){
		isFree = false;
		// 将“12345678”替换成您申请的APPID，申请地址：http://open.voicecloud.cn  
		SpeechUtility.createUtility(SpeechConstant.APPID +"=57a011cc");  
		
		//1.创建SpeechSynthesizer对象  
		SpeechSynthesizer mTts= SpeechSynthesizer.createSynthesizer( );  
		//2.合成参数设置，详见《iFlytek MSC Reference Manual》SpeechSynthesizer 类  
		mTts.setParameter(SpeechConstant.VOICE_NAME, info.getVoice());//设置发音人  
		mTts.setParameter(SpeechConstant.SPEED, "50");//设置语速  
		mTts.setParameter(SpeechConstant.VOLUME, "80");//设置音量，范围0~100  
		//设置合成音频保存位置（可自定义保存位置），保存在“./iflytek.pcm”  
		//如果不需要保存合成音频，注释该行代码  
		mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, "./iflytek.pcm"); 
		//合成监听器  
		SynthesizerListener mSynListener = new SynthesizerListener(){  
		    //会话结束回调接口，没有错误时，error为null  
		    public void onCompleted(SpeechError error) {
		    	isFree = true;
		    }  
		    //缓冲进度回调  
		    //percent为缓冲进度0~100，beginPos为缓冲音频在文本中开始位置，endPos表示缓冲音频在文本中结束位置，info为附加信息。  
		    public void onBufferProgress(int percent, int beginPos, int endPos, String info) {}  
		    //开始播放  
		    public void onSpeakBegin() {}
		    //暂停播放  
		    public void onSpeakPaused() {}  
		    //播放进度回调  
		    //percent为播放进度0~100,beginPos为播放音频在文本中开始位置，endPos表示播放音频在文本中结束位置.  
		    public void onSpeakProgress(int percent, int beginPos, int endPos) {}  
		    //恢复播放回调接口  
		    public void onSpeakResumed() {}  
		};  
		//3.开始合成  
		mTts.startSpeaking(info.getWord(), mSynListener);  
	}
}

class TalkInfo{
	private String word;
	private String voice;
	public TalkInfo(String word, String voice) {
		super();
		this.word = word;
		this.voice = voice;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getVoice() {
		return voice;
	}
	public void setVoice(String voice) {
		this.voice = voice;
	}
	
}