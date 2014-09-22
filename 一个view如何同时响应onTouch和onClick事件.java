/**һ��view���ͬʱ��ӦonTouch��onClick�¼�
 
����Ŀ�����������⣬��Ҫͬʱ��imageVIew����onTouch��onClick�¼� �� ��onTouch�¼���ִ���϶���������onClick��ִ����ʾһ���Ի��򣬿��������¼�һֱ�г�ͻ��onTouch�¼��ķ���ֵ��boolean���͵ģ��������true ����ô�Ͱ��¼����أ�onclick�϶��޷���Ӧ������false����ͬʱִ��onClick������Ҫ���OnTouch��onClick�¼���ȫ����
�֣������뵽��һ�����Ǻ�������ʹ����ȫû�д���ķ����������� OnTouch�е�MotionEvent.ACTION_DOWN ʱ����¼�µ㣨X1��Y1������ MotionEvent.ACTION_UP ʱ����¼�µ㣨X2��Y2����Ȼ��ȶ� ����֮��ľ��룬���С��һ����С��ֵ������5��������Ϊ��Click�¼���onTouch�з���false���������ϴ󣬿��Ե���onTouch�¼�ȥ��������true��
ʾ�����£�
 **/
@Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();
                x1 =  event.getRawX();//�õ����Ӧ��Ļ���Ͻǵ�����
                y1 =  event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = (int) event.getRawX() - lastX;
                int dy = (int) event.getRawY() - lastY;

                int left = v.getLeft() + dx;
                int top = v.getTop() + dy;
                int right = v.getRight() + dx;
                int bottom = v.getBottom() + dy;
                if (left < 0) {
                    left = 0;
                    right = left + v.getWidth();
                }
                if (right > screenWidth) {
                    right = screenWidth;
                    left = right - v.getWidth();
                }
                if (top < 0) {
                    top = 0;
                    bottom = top + v.getHeight();
                }
                if (bottom > screenHeight) {
                    bottom = screenHeight;
                    top = bottom - v.getHeight();
                }
                v.layout(left, top, right, bottom);
                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getRawX();
                y2 = event.getRawY();
                Log.i("i", x1 + ",,," + y1 +",,,"+x2+",,,"+y2);
                double distance = Math.sqrt(Math.abs(x1-x2)*Math.abs(x1-x2)+Math.abs(y1-y2)*Math.abs(y1-y2));//����֮��ľ���
                Log.i("i", "x1 - x2>>>>>>"+ distance);
                 if (distance < 15) { // �����С������click�¼������� 
                     showToastDialog("�����");
                    return false;
                 } else {
                     showToastDialog("������");
                    return true ;
                }
        }
        return false;   
    }
 
