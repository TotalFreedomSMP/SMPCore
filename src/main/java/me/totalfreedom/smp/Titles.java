package me.totalfreedom.smp;

import java.util.Arrays;
import java.util.List;

public class Titles
{
    public static final List<String> OWNERS;
    public static final List<String> DEVELOPERS;
    public static final List<String> EXECUTIVES;
    public static final List<String> SENIORS;
    public static final List<String> TELNETS;
    public static final List<String> SUPERS;
    public static final List<String> MASTERBUILDERS;

    static
    {
        OWNERS = Arrays.asList("Catholic_Mario", "RobinGall2910", "smartnt");
        DEVELOPERS = Arrays.asList("supernt", "smartnt", "OxLemonxO");
        EXECUTIVES = Arrays.asList("RealZaid", "_Fleek", "Waspter", "GL1zy");
        SENIORS = Arrays.asList("Cowgomooo12", "Finest95", "xNyanPanda", "ItsZekrom", "JJ_Jaguar2000", "Lioneric", "_PHR", "MEGAF4IL", "mibbzz", "Premintex", "rrj112", "TiccingSkennec", "sKsKsKaEsKsKs", "Szech", "Toska_1", "VideoGameSmash12", "_Windows", "MrPerson660", "neroblackcat");
        TELNETS = Arrays.asList("Alco_Rs11", "Alosion", "AndySixxBVB", "falceso", "RealFionn", "Ginlang", "Gommeh", "je_ist_happy", "DarthZonarius", "CujohJolyne", "Copyy", "mattlawn", "Rhymix", "squarent", "SupItsDillon", "taahanis", "Telesphoreo", "travislamoon", "untuned", "XxChrisProxX", "Zyrusse", "230Daniel", "Scribbles4321", "Renegading");
        SUPERS = Arrays.asList("1cloud_", "Blue_moon_kun", "Captainclimber", "CendragRoseheart", "CoconutCereal", "decyj145", "DragonSlayer2189", "iiFrozenFireii", "MrDicty", "sergio24m", "xBruhMoment_", "thexaccused", "ChikoritaMoon");
        MASTERBUILDERS = Arrays.asList("BurgerBoyPlayz", "Dusty01", "Inpace", "jwmphall", "Maley", "xfilez");
    }

    public static boolean isOwner(final String name)
    {
        return Titles.OWNERS.contains(name);
    }

    public static boolean isDeveloper(final String name)
    {
        return Titles.DEVELOPERS.contains(name);
    }

    public static boolean isExecutive(final String name)
    {
        return Titles.EXECUTIVES.contains(name);
    }

    public static boolean isSenior(final String name)
    {
        return Titles.SENIORS.contains(name);
    }

    public static boolean isTelnet(final String name)
    {
        return Titles.TELNETS.contains(name);
    }

    public static boolean isSuper(final String name)
    {
        return Titles.SUPERS.contains(name);
    }

    public static boolean isMasterBuilder(final String name)
    {
        return Titles.MASTERBUILDERS.contains(name);
    }
}
