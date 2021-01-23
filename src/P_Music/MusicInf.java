package P_Music;

/******
 * ��������Ϣ�ṹ
 * @author JERRY
 *
 */
public class MusicInf {
	private String name;		//������
	private String path;		//����·��
	private int length;			//������ʱ��
	private int size;			//�����ܱ�����
	
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
	 * ��ȡ������ʱ����
	 * @return ��ʱ��
	 */
	public int getLength() {
		return length;
	}

	/***
	 * ���ø�����ʱ��
	 * @param length
	 */
	public void setLength(int length) {
		this.length = length;
	}
	
	/***
	 * ��ȡ�����ܱ�����
	 * @return �ܱ�����
	 */
	public int getSize() {
		return size;
	}

	/***
	 * ���ø����ܱ�����
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
