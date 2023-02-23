package Stack.StackUsingLinkedList;

public class ourStackUse {

    public static void main(String[] args) {

        StackClass<Integer> st= new StackClass<>();

        st.Push(10);
        st.Push(20);
        st.Push(30);
        st.Push(40);
        st.Push(50);
        st.Peek();
        st.Pop();
        st.Pop();
        st.Size();

    }

}

