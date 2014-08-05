

import android.app.Activity;
import android.app.AlertDialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TextView;


public class AlertDialogTest extends Activity
{
	TextView show;
	String[] items = new String[] { 
			"�Զ���view1", "�Զ���view2",
			"�Զ���view3",
			"�Զ���view4" };	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		show = (TextView) findViewById(R.id.show);
	}

	public void simple(View source)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
			// ���öԻ������
			.setTitle("�򵥶Ի���")
			// ����ͼ��
			.setIcon(R.drawable.tools)
			.setMessage("�Ի���Ĳ�������\n�ڶ�������");
		// ΪAlertDialog.Builder��ӡ�ȷ������ť
		setPositiveButton(builder);
		// ΪAlertDialog.Builder��ӡ�ȡ������ť
		setNegativeButton(builder)
			.create()
			.show();
	}

	public void simpleList(View source)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
			// ���öԻ������
			.setTitle("���б���Ի���")
			// ����ͼ��
			.setIcon(R.drawable.tools)
			// ���ü򵥵��б�������
			.setItems(items, new OnClickListener()
			{
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					show.setText("��ѡ���ˡ�" + items[which] + "��");
				}
			});
		// ΪAlertDialog.Builder��ӡ�ȷ������ť
		setPositiveButton(builder);
		// ΪAlertDialog.Builder��ӡ�ȡ������ť
		setNegativeButton(builder)
			.create()
			.show();
	}

	public void singleChoice(View source)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
			// ���öԻ������
			.setTitle("��ѡ�б���Ի���")
			// ����ͼ��
			.setIcon(R.drawable.tools)
			// ���õ�ѡ�б���,Ĭ��ѡ�еڶ������Ϊ1��
			.setSingleChoiceItems(items, 1, new OnClickListener()
			{
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					show.setText("��ѡ���ˡ�" + items[which] + "��");
				}
			});
		// ΪAlertDialog.Builder��ӡ�ȷ������ť
		setPositiveButton(builder);
		// ΪAlertDialog.Builder��ӡ�ȡ������ť
		setNegativeButton(builder)
			.create()
			.show();
	}
	public void multiChoice(View source)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
			// ���öԻ������
			.setTitle("��ѡ�б���Ի���")
			// ����ͼ��
			.setIcon(R.drawable.tools)
			// ���ö�ѡ�б�����ù�ѡ��2���4��
			.setMultiChoiceItems(items
			, new boolean[]{false , true ,false ,true}, null);
		// ΪAlertDialog.Builder��ӡ�ȷ������ť
		setPositiveButton(builder);
		// ΪAlertDialog.Builder��ӡ�ȡ������ť
		setNegativeButton(builder)
			.create()
			.show();
	}
	public void customList(View source)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
			// ���öԻ������
			.setTitle("�Զ����б���Ի���")
			// ����ͼ��
			.setIcon(R.drawable.tools)
			// �����Զ����б���
			.setAdapter(new ArrayAdapter<String>(this 
					, R.layout.array_item 
					, items), null);
		// ΪAlertDialog.Builder��ӡ�ȷ������ť
		setPositiveButton(builder);
		// ΪAlertDialog.Builder��ӡ�ȡ������ť
		setNegativeButton(builder)
			.create()
			.show();
	}
	
	public void customView(View source)
	{
		//װ��/res/layout/login.xml���沼��
		TableLayout loginForm = (TableLayout)getLayoutInflater()
			.inflate( R.layout.login, null);		
		new AlertDialog.Builder(this)
			// ���öԻ����ͼ��
			.setIcon(R.drawable.tools)
			// ���öԻ���ı���
			.setTitle("�Զ���View�Ի���")
			// ���öԻ�����ʾ��View����
			.setView(loginForm)
			// Ϊ�Ի�������һ����ȷ������ť
			.setPositiveButton("��¼" , new OnClickListener()
			{
				@Override
				public void onClick(DialogInterface dialog,
						int which)
				{
					// �˴���ִ�е�¼����
				}
			})
			// Ϊ�Ի�������һ����ȡ������ť
			.setNegativeButton("ȡ��", new OnClickListener()
			{
				@Override
				public void onClick(DialogInterface dialog,
						int which)
				{
					// ȡ����¼�������κ����顣
				}
			})
			// ����������ʾ�Ի���
			.create()
			.show();
	}
	
	private AlertDialog.Builder setPositiveButton(
			AlertDialog.Builder builder)
	{
		// ����setPositiveButton�������ȷ����ť
		return builder.setPositiveButton("ȷ��", new OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				show.setText("�����ˡ�ȷ������ť��");
			}
		});
	}
	
	private AlertDialog.Builder setNegativeButton(
			AlertDialog.Builder builder)
	{
		// ����setNegativeButton�������ȡ����ť
		return builder.setNegativeButton("ȡ��", new OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				show.setText("�����ˡ�ȡ������ť��");
			}
		});
	}
}