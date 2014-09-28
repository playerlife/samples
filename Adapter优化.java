    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vHolder = null;
        //���convertView����Ϊ���򴴽��¶��󣬲�Ϊ������  
        if (convertView == null) {
            convertView = inflater.inflate(..., null);
            // ���� ViewHodler ����  
            vHolder = new ViewHolder();
            vHolder.img= (ImageView) convertView.findViewById(...);
            vHolder.tv= (TextView) convertView.findViewById(...);
            // ��ViewHodler���浽Tag��(Tag���Խ���Object���Ͷ��������κζ��������Ա���������)
            convertView.setTag(vHolder);
        } else {
            //��convertView��Ϊ��ʱ��ͨ��getTag()�õ�View  
            vHolder = (ViewHolder) convertView.getTag();
        }
        // ������ֵ���޸���ʾ��ֵ  
        vHolder.img.setImageBitmap(...);
        vHolder.tv.setText(...);
        return convertView;
    }
    //����ʾ��View ��װ����  
    static class ViewHolder {
        TextView tv;
        ImageView img;
    }