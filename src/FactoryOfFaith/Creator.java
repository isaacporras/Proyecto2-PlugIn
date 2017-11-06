package FactoryOfFaith;

class Creator
{
    public static Placer createIf() {
        return new vIf();
    }

    public static Placer createWhile() {
        return new vWhile();
    }

    public static Placer createFor() {
        return new vFor();
    }

    public static Placer createDeclare() {
        return new vDeclare();
    }

    public static Placer createMethod() {
        return new vMethod();
    }
    
}