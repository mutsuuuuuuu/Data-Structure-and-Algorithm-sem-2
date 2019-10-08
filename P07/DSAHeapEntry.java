class DSAHeapEntry
{
    private int priority;
    private Object value;
    
    public DSAHeapEntry(int inPriority, Object inValue)
    {
        this.priority = inPriority;
        this.value = inValue;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }
    
    public int getPriority()
    {
        return this.priority;
    }
    
    public Object getValue()
    {
        return this.value;
    }

    public int toInt()
    {
        return getPriority();
    }

    @Override
    public String toString()
    {
        return "Priority: "+String.valueOf(priority) +" Value: " + value.toString()+"\n";
    }
}
