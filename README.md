# ExceptionalFramework
No need of try catch block in code just avoid exception using annotations and get message appropriate to exception that occured.

Example:
Create class Foo as below. Then insted of haveing try catch exceptions can cought by using @CatchGroup and @Catch annotations.


    class Foo {
      @CatchGroup(catchers = { @Catch(targetException = ArithmeticException.class),
          @Catch(targetException = NullPointerException.class) })
      public void callMethod() throws Throwable {
        int a = 0, b = 10;
        System.out.println(b / a);
      }

      public static void main(String[] args) throws Exception {
        Foo foo = new Foo();
        MethodCaller.callMethod(foo);
      }
    }
 
 
