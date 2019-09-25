public class DSAHashEntry
{
    private String key;
    private Object value;
    private int state;

    public DSAHashEntry()
    {
        key = "";
        value = null;
        state = 0;
    }

    public DSAHashEntry(String inkey, Object inValue)
    {
        this.key = inkey;
        this.value = inValue;
        this.state = 1;
    }
    
    public void setKey(String inKey)
    {
        this.key = inKey;
    }
    
    public void setValue(Object inValue)
    {
        this.value = inValue;
    }

    public void setState(int inState)
    {
        this.state=inState;
    }

    public String getKey()
    {
        return this.key;
    }
    
    public Object getValue()
    {
        return this.value;
    }

    public int getState()
    {
        return this.state;
    }

    @Override
    public String toString()
    {
        return getKey();
    }
}
