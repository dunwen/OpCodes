public interface Opcodes {
  int NOP = 0; // visitInsn 代表什么都不做
  int ACONST_NULL = 1; // - 把null推到栈顶
  
  /*
  *  ICONST系列只能把 -1 ~ 5 推到栈顶，其它int类型，需要使用PUSH系列命令
  */
  int ICONST_M1 = 2; // - 把 -1 推到栈顶
  int ICONST_0 = 3; // - 把 int 0 推到栈顶
  int ICONST_1 = 4; // - 把 int 1 推到栈顶
  int ICONST_2 = 5; // - 把 int 2 推到栈顶
  int ICONST_3 = 6; // - 把 int 3 推到栈顶
  int ICONST_4 = 7; // - 把 int 4 推到栈顶
  int ICONST_5 = 8; // - 把 int 5 推到栈顶
  
  /*
  * LCONST系列智能把 0 ~ 1 推到栈顶，其它long类型，需要使用LDC命令
  * 同理，FCONST/DCONST也如此
  */
  int LCONST_0 = 9; // - 
  int LCONST_1 = 10; // -
  int FCONST_0 = 11; // -
  int FCONST_1 = 12; // -
  int FCONST_2 = 13; // -
  int DCONST_0 = 14; // -
  int DCONST_1 = 15; // -
  
  int BIPUSH = 16; // visitIntInsn 将单字节的常量值(-128~127)推送至栈顶
  int SIPUSH = 17; // - 将一个短整型常量值(-32768~32767)推送至栈顶
  int LDC = 18; // visitLdcInsn 将int, float或String型常量值从常量池中推送至栈顶
  
  /*
  * 该系列把本地第？个变量推到栈顶
  * 非静态函数的第0个变量代表this
  * 这一个load系列后面跟的数值，不按类型递增
  */
  int ILOAD = 21; // visitVarInsn 
  int LLOAD = 22; // -
  int FLOAD = 23; // -
  int DLOAD = 24; // -
  int ALOAD = 25; // -
  
  
  /*
  * 该系列命令负责把数组的某项送到栈顶
  * 比如下面代码
  * String[] arr = new String[] {"1","2"};
  * String i = arr[1];
  * 相关对应的字节码
  * ALOAD 1 // 数组在程序的函数里面是第一个变量，取出来
  * ICONST_1 // 需要推到栈顶的数组下标取出来
  * AALOAD // 把数组的那个下标的引用对象（这里的String是引用对象）推到栈顶
  * ASTORE 2 // 赋值给i,i在我的程序里面是第二个本地变量
  */
  int IALOAD = 46; // visitInsn
  int LALOAD = 47; // -
  int FALOAD = 48; // -
  int DALOAD = 49; // -
  int AALOAD = 50; // -
  int BALOAD = 51; // - 
  int CALOAD = 52; // - char 类型
  int SALOAD = 53; // - short 类型
  
  /*
  * STORE系列，把栈顶存入本地变量，所谓的本地变量，就是方法体内的变量
  * XSTORE [?] ?从0或1开始一直递增，
  * 对于静态函数 XSTORE [?] ?从0开始，对于非静态函数，从1开始，因为非静态函数的第0个本地变量是this,this这个本地变量是只读的
  */
  int ISTORE = 54; // visitVarInsn
  int LSTORE = 55; // -
  int FSTORE = 56; // -
  int DSTORE = 57; // -
  int ASTORE = 58; // - 把栈顶引用类型存入本地变量
  
  /*
  * 该系列命令负责把栈顶项的值存到数组里。
  * 该命令根据栈里内容来确定对哪个数组的哪项进行操作。
  * 比如下面代码
  *  int[] arr = new int[5];
  *	 arr[1] = 1000;
  *	 
  *	 ALOAD 0 // 数组在我的程序里是静态函数的第一个变量
  * ICONST_1 // 取出下标，推到栈顶
  * SIPUSH 1000 // 取出数值，推到栈顶
  * IASTORE // 往数组里面的下标赋值
  */
  int IASTORE = 79; // visitInsn int 类型
  int LASTORE = 80; // - long 类型
  int FASTORE = 81; // - float 类型
  int DASTORE = 82; // - double 类型
  int AASTORE = 83; // - 引用类型
  int BASTORE = 84; // - boolean 类型
  int CASTORE = 85; // - char 类型
  int SASTORE = 86; // - short 类型
  
  
  int POP = 87; // - 将栈顶数值弹出 (数值不能是long或double类型的)
  int POP2 = 88; // - 将栈顶的一个（long或double类型的)或两个数值弹出（其它）
  int DUP = 89; // - 复制栈顶数值(数值不能是long或double类型的)并将复制值压入栈顶
  int DUP_X1 = 90; // - 复制栈顶数值(数值不能是long或double类型的)并将两个复制值压入栈顶
  int DUP_X2 = 91; // - 复制栈顶数值(数值不能是long或double类型的)并将三个（或两个）复制值压入栈顶
  int DUP2 = 92; // - 复制栈顶一个（long或double类型的)或两个（其它）数值并将复制值压入栈顶
  int DUP2_X1 = 93; // - 复制栈顶数值(long或double类型的)并将两个复制值压入栈顶
  int DUP2_X2 = 94; // - 复制栈顶数值(long或double类型的)并将三个（或两个）复制值压入栈顶
  int SWAP = 95; // - 将栈最顶端的两个数值互换(数值不能是long或double类型的)
  
  int IADD = 96; // - 将栈顶两int型数值相加并将结果压入栈顶
  int LADD = 97; // -
  int FADD = 98; // -
  int DADD = 99; // -

  int ISUB = 100; // - 将栈顶两int型数值相减并将结果压入栈顶
  int LSUB = 101; // -
  int FSUB = 102; // -
  int DSUB = 103; // -
  
  int IMUL = 104; // - 将栈顶两int型数值相乘并将结果压入栈顶
  int LMUL = 105; // -
  int FMUL = 106; // -
  int DMUL = 107; // -

  int IDIV = 108; // - 将栈顶两int型数值相除并将结果压入栈顶
  int LDIV = 109; // -
  int FDIV = 110; // -
  int DDIV = 111; // -

  int IREM = 112; // - 将栈顶两int型数值作取模运算并将结果压入栈顶
  int LREM = 113; // -
  int FREM = 114; // -
  int DREM = 115; // -

  int INEG = 116; // - 将栈顶int型数值取负并将结果压入栈顶
  int LNEG = 117; // -
  int FNEG = 118; // -
  int DNEG = 119; // -

  int ISHL = 120; // - 将int型数值左移位指定位数并将结果压入栈顶
  int LSHL = 121; // -

  int ISHR = 122; // - 将int型数值右（符号）移位指定位数并将结果压入栈顶
  int LSHR = 123; // -

  int IUSHR = 124; // - 将int型数值右（无符号）移位指定位数并将结果压入栈顶
  int LUSHR = 125; // -

  int IAND = 126; // - 将栈顶两int型数值作“按位与”并将结果压入栈顶
  int LAND = 127; // -

  int IOR = 128; // - 将栈顶两int型数值作“按位或”并将结果压入栈顶
  int LOR = 129; // -

  int IXOR = 130; // - 将栈顶两int型数值作“按位异或”并将结果压入栈顶
  int LXOR = 131; // -

  int IINC = 132; // visitIincInsn 该指令用于对本地(局部)变量进行自增减操作。该指令第一参数为本地变量的编号，第二个参数为自增减的数量 

  /*
  * 类型转化系列 int to long 啥的 
  */
  int I2L = 133; // visitInsn
  int I2F = 134; // -
  int I2D = 135; // -
  int L2I = 136; // -
  int L2F = 137; // -
  int L2D = 138; // -
  int F2I = 139; // -
  int F2L = 140; // -
  int F2D = 141; // -
  int D2I = 142; // -
  int D2L = 143; // -
  int D2F = 144; // -
  int I2B = 145; // -
  int I2C = 146; // -
  int I2S = 147; // -



  int LCMP = 148; // - 比较栈顶两long型数值大小，并将结果（1，0，-1）压入栈顶
  int FCMPL = 149; // - 比较栈顶两float型数值大小，并将结果（1，0，-1）压入栈顶；当其中一个数值为NaN时，将-1压入栈顶
  int FCMPG = 150; // - 比较栈顶两float型数值大小，并将结果（1，0，-1）压入栈顶；当其中一个数值为NaN时，将1压入栈顶
  int DCMPL = 151; // - 比较栈顶两double型数值大小，并将结果（1，0，-1）压入栈顶；当其中一个数值为NaN时，将-1压入栈顶
  int DCMPG = 152; // - 比较栈顶两double型数值大小，并将结果（1，0，-1）压入栈顶；当其中一个数值为NaN时，将1压入栈顶


  int IFEQ = 153; // visitJumpInsn 当栈顶int型数值等于0时跳转,第二参数接label名字（L[?]）
  int IFNE = 154; // - 当栈顶int型数值不等于0时跳转
  int IFLT = 155; // - 当栈顶int型数值小于0时跳转
  int IFGE = 156; // - 当栈顶int型数值大于等于0时跳转
  int IFGT = 157; // - 当栈顶int型数值大于0时跳转
  int IFLE = 158; // - 当栈顶int型数值小于等于0时跳转
  int IF_ICMPEQ = 159; // - 比较栈顶两int型数值大小，当结果等于0时跳转
  int IF_ICMPNE = 160; // - 比较栈顶两int型数值大小，当结果不等于0时跳转
  int IF_ICMPLT = 161; // - 比较栈顶两int型数值大小，当结果小于0时跳转
  int IF_ICMPGE = 162; // - 比较栈顶两int型数值大小，当结果大于等于0时跳转
  int IF_ICMPGT = 163; // - 比较栈顶两int型数值大小，当结果大于0时跳转
  int IF_ICMPLE = 164; // - 比较栈顶两int型数值大小，当结果小于等于0时跳转
  int IF_ACMPEQ = 165; // - 比较栈顶两引用型数值，当结果相等时跳转
  int IF_ACMPNE = 166; // - 比较栈顶两引用型数值，当结果不相等时跳转

  int GOTO = 167; // - 无条件跳转
  int JSR = 168; // - 跳转至指定16位offset位置，并将jsr下一条指令地址压入栈顶
  int RET = 169; // visitVarInsn 返回至本地变量指定的index的指令位置（一般与jsr, jsr_w联合使用）
  int TABLESWITCH = 170; // visiTableSwitchInsn 用于switch条件跳转，case值连续（可变长度指令）
  int LOOKUPSWITCH = 171; // visitLookupSwitch 用于switch条件跳转，case值不连续（可变长度指令）

  /*
  * 返回指令系列
  */
  int IRETURN = 172; // visitInsn
  int LRETURN = 173; // -
  int FRETURN = 174; // -
  int DRETURN = 175; // -
  int ARETURN = 176; // -
  int RETURN = 177; // -

  /*
  * 该系列指令用于对静态域（STATIC）和非静态域(FIELD)进行读写。该系列命令需要跟一个表明域编号的参数
  * 举个栗子 第一参数规则是  全限定类名.变量名 : 该变量类型
  * GETSTATIC com/dunwen/Test.str : Ljava/lang/String;
  */
  int GETSTATIC = 178; // visitFieldInsn
  int PUTSTATIC = 179; // -
  int GETFIELD = 180; // -
  int PUTFIELD = 181; // -

  /*
  * 该系列指令用于对静态方法和非静方法进行调用。该系列命令需要跟一个表明方法编号的参数。
  * 如果方法有传入参数的话，则需要先压栈到栈顶。另外，方法的返回参数是保存到栈顶的，因此我们可以通过栈道值取得方法的返回值。
  * 举个栗子：
  * public void test() {
  *  make(1,1);
  *	}
  * 变成字节码就是
  * ALOAD 0
  * ICONST_1
  * ICONST_1
  * INVOKEVIRTUAL com/dunwen/Test.make (II)V
  */
  int INVOKEVIRTUAL = 182; // visitMethodInsn 调用实例方法
  int INVOKESPECIAL = 183; // - 调用超类构造方法，实例初始化方法，私有方法
  int INVOKESTATIC = 184; // - 调用静态方法
  int INVOKEINTERFACE = 185; // - 调用接口方法
  int INVOKEDYNAMIC = 186; // visitInvokeDynamicInsn 


  int NEW = 187; // visitTypeInsn 创建一个对象，并将其引用值压入栈顶   NEW java/lang/String
  int NEWARRAY = 188; // visitIntInsn 创建一个指定原始类型（如int, float, char…）的数组，并将其引用值压入栈顶
  int ANEWARRAY = 189; // visitTypeInsn 创建一个引用型（如类，接口，数组）的数组，并将其引用值压入栈顶
  int ARRAYLENGTH = 190; // visitInsn 获得数组的长度值并压入栈顶

  int ATHROW = 191; // - 将栈顶的异常抛出

  int CHECKCAST = 192; // visitTypeInsn 检验类型转换，检验未通过将抛出ClassCastException
  int INSTANCEOF = 193; // - 检验对象是否是指定的类的实例，如果是将1压入栈顶，否则将0压入栈顶
  int MONITORENTER = 194; // visitInsn 获得对象的锁，用于同步方法或同步块
  int MONITOREXIT = 195; // - 释放对象的锁，用于同步方法或同步块

  int MULTIANEWARRAY = 197; // visitMultiANewArrayInsn 创建指定类型和指定维度的多维数组（执行该指令时，操作栈中必须包含各维度的长度值），并将其引用值压入栈顶
  int IFNULL = 198; // visitJumpInsn 为null时跳转
  int IFNONNULL = 199; // - 不为null时跳转
 } 
