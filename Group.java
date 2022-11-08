class Group{
    private int institute_id;
    private int id;

    public Group(int m_id, int m_institute_id){
        id = m_id;
        institute_id = m_institute_id;
    }
    public int getId(){
        return id;
    };
    public int getInstitute_id() {return institute_id;};
}