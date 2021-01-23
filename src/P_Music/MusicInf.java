package P_Music;

/******
 * 歌曲类信息结构
 * @author JERRY
 *
 */
public class MusicInf {
	private String name;		//歌曲名
	private String path;		//歌曲路径
	private int length;			//歌曲总时长
	private int size;			//歌曲总比特数
	
	public MusicInf() {
		
	}
	
	public MusicInf(String name,String path,int length,int size) {
		this.name = name;
		this.path = path;
		this.length = length;
		this.size = size;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	/***
	 * 获取歌曲总时长数
	 * @return 总时长
	 */
	public int getLength() {
		return length;
	}

	/***
	 * 设置歌曲总时长
	 * @param length
	 */
	public void setLength(int length) {
		this.length = length;
	}
	
	/***
	 * 获取歌曲总比特数
	 * @return 总比特数
	 */
	public int getSize() {
		return size;
	}

	/***
	 * 设置歌曲总比特数
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return name + "@#@" + path + "@#@" + length + "@#@" + size;
	}
}
