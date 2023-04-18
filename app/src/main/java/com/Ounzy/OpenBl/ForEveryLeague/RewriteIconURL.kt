package com.Ounzy.OpenBl.ui.components.Tables

fun rewriteIconUrl(url: String): String {

    // OpenLigaDB German leagues
    if (url.contains("https://assets.dfb.de/uploads/000/018/232/small_union-Berlin.jpg")) return "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/1._FC_Union_Berlin_Logo.svg/2000px-1._FC_Union_Berlin_Logo.svg.png"
    if (url.contains("http://upload.wikimedia.org/wikipedia/de/thumb/f/ff/1._FC_Saarbr%C3%BCcken.svg/150px-1._FC_Saarbr%C3%BCcken.svg.png")) return "https://upload.wikimedia.org/wikipedia/de/f/ff/1._FC_Saarbr%C3%BCcken.svg"
    if (url.contains("https://www.openligadb.de/images/teamicons/SC_Verl.gif")) return "https://upload.wikimedia.org/wikipedia/commons/c/ce/SC_Verl_Logo.svg"
    if (url.contains("https://www.openligadb.de/images/teamicons/Borussia_Dortmund.gif")) return "https://upload.wikimedia.org/wikipedia/commons/6/67/Borussia_Dortmund_logo.svg"
    if (url.contains("https://www.openligadb.de/images/teamicons/Rot_Weiss_Essen.gif")) return "https://upload.wikimedia.org/wikipedia/de/8/8a/Logo_Rot-Weiss_Essen.svg"
    if (url.contains("https://upload.wikimedia.org/wikipedia/de/thumb/5/55/FC-Ingolstadt_logo.svg/125px-FC-Ingolstadt_logo.svg.png")) return "https://upload.wikimedia.org/wikipedia/de/5/55/FC-Ingolstadt_logo.svg"
    if (url.contains("https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/Svwaldhof.svg/150px-Svwaldhof.svg.png")) return "https://upload.wikimedia.org/wikipedia/commons/1/17/Svwaldhof.svg"
    if (url.contains("https://upload.wikimedia.org/wikipedia/en/thumb/6/6d/SC_Freiburg_logo.svg/225px-SC_Freiburg_logo.svg.png")) return "https://upload.wikimedia.org/wikipedia/als/f/f1/SC-Freiburg_Logo-neu.svg"
    if (url.contains("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/Logo_SG_Dynamo_Dresden_neu.svg/284px-Logo_SG_Dynamo_Dresden_neu.svg.png")) return "https://upload.wikimedia.org/wikipedia/commons/e/e1/Logo_SG_Dynamo_Dresden_neu.svg"
    if (url.contains("https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/SV_Meppen_Logo.svg/150px-SV_Meppen_Logo.svg.png")) return "https://upload.wikimedia.org/wikipedia/commons/5/55/SV_Meppen_Logo.svg"
    if (url.contains("https://upload.wikimedia.org/wikipedia/de/thumb/0/01/FSV_Zwickau_Logo.svg/120px-FSV_Zwickau_Logo.svg.png")) return "https://upload.wikimedia.org/wikipedia/de/0/01/FSV_Zwickau_Logo.svg"
    if (url.contains("https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/VfB_Oldenburg.svg/200px-VfB_Oldenburg.svg.png")) return "https://upload.wikimedia.org/wikipedia/commons/b/bc/VfB_Oldenburg.svg"
    if (url.contains("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/Hallescher_FC.svg/150px-Hallescher_FC.svg.png")) return "https://upload.wikimedia.org/wikipedia/commons/e/e1/Hallescher_FC.svg"
    if (url.contains("https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Fortuna_D%C3%BCsseldorf.svg/150px-Fortuna_D%C3%BCsseldorf.svg.png")) return "https://upload.wikimedia.org/wikipedia/commons/9/94/Fortuna_D%C3%BCsseldorf.svg"
    if (url.contains("https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Holstein_Kiel_Logo.svg/300px-Holstein_Kiel_Logo.svg.png")) return "https://upload.wikimedia.org/wikipedia/commons/3/30/Holstein_Kiel_Logo.svg"
    if (url.contains("https://upload.wikimedia.org/wikipedia/commons/thumb/8/84/1._FC_Magdeburg.svg/210px-1._FC_Magdeburg.svg.png")) return "https://upload.wikimedia.org/wikipedia/commons/8/84/1._FC_Magdeburg.svg"
    if (url.contains("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Jahn_Regensburg_logo2014.svg/204px-Jahn_Regensburg_logo2014.svg.png")) return "https://upload.wikimedia.org/wikipedia/commons/5/5a/SSV_Jahn_Regensburg.svg"

    //Kicker Premier League
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2009/fussball/vereine/xxl/500.png")) return "https://upload.wikimedia.org/wikipedia/sco/5/53/Arsenal_FC.svg"
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2017/fussball/vereine/xxl/1343_20160915670.png")) return "https://upload.wikimedia.org/wikipedia/sco/e/eb/Manchester_City_FC_badge.svg"
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2021/fussball/vereine/xxl/513_20210308405.png")) return "https://upload.wikimedia.org/wikipedia/sco/7/7a/Manchester_United_FC_crest.svg"
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2021/fussball/vereine/xxl/514_20210308624.png")) return "https://upload.wikimedia.org/wikipedia/sco/5/56/Newcastle_United_Logo.svg"
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2021/fussball/vereine/xxl/517_20210308694.png")) return "https://upload.wikimedia.org/wikipedia/de/b/b4/Tottenham_Hotspur.svg"
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2023/fussball/vereine/xxl/501_20220723523.png")) return "https://upload.wikimedia.org/wikipedia/de/9/9f/Aston_Villa_logo.svg"
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2013/fussball/vereine/xxl/1942_20161206905.png")) return "https://upload.wikimedia.org/wikipedia/de/b/bf/Brighton_and_hove_albion.svg"
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2009/fussball/vereine/xxl/512_20180315108.png")) return "https://upload.wikimedia.org/wikipedia/de/0/0a/FC_Liverpool.svg"
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2018/fussball/vereine/xxl/1929_20170906518.png")) return "https://static.wikia.nocookie.net/logopedia/images/9/95/Brentford_FC_2017.png/revision/latest?cb=20200827054411"                           //Brentford
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2021/fussball/vereine/xxl/1166_20210310443.png")) return "https://upload.wikimedia.org/wikipedia/de/a/a8/Fulham_fc.svg"
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2009/fussball/vereine/xxl/505.png")) return "https://upload.wikimedia.org/wikipedia/de/5/5c/Chelsea_crest.svg"
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2013/fussball/vereine/xxl/507_2013820122840476.png")) return "https://upload.wikimedia.org/wikinews/en/0/0c/Crystal_Palace_FC_logo.svg"
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2021/fussball/vereine/xxl/1460_20210523035.png")) return "https://upload.wikimedia.org/wikipedia/sco/f/fc/Wolverhampton_Wanderers.svg"
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2006/fussball/vereine/xxl/1923_20131126112727514.png")) return "https://upload.wikimedia.org/wikipedia/de/4/41/Afc_bournemouth.svg"
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2021/fussball/vereine/xxl/518_20210308312.png")) return "https://upload.wikimedia.org/wikipedia/sco/c/c2/West_Ham_United_FC_logo.svg"
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2006/fussball/vereine/xxl/510_20151006484.png")) return "https://upload.wikimedia.org/wikipedia/de/d/de/Leeds_United.svg"  // Leeds United
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2021/fussball/vereine/xxl/509_20210308851.png")) return "https://upload.wikimedia.org/wikipedia/sco/7/7c/Everton_FC_logo.svg"
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2023/fussball/vereine/xxl/1220_20230206842.png")) return "https://upload.wikimedia.org/wikipedia/sco/d/d2/Nottingham_Forest_logo.svg" //Nottingham Forest
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2006/fussball/vereine/xxl/511_2014113111116962.png")) return "https://upload.wikimedia.org/wikipedia/de/b/b6/Leicester_City.svg" //Leicester City
    if (url.contains("https://derivates.kicker.de/image/fetch/w_30,h_30,c_fit,q_auto:best/https://mediadb.kicker.de/2006/fussball/vereine/xxl/516_201372311252407.png")) return "https://upload.wikimedia.org/wikipedia/de/c/c9/FC_Southampton.svg"

    return url
}