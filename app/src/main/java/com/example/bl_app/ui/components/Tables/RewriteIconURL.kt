package com.example.bl_app.ui.components.Tables

fun rewriteIconUrl(url: String): String {
    if (url.contains("https://assets.dfb.de/uploads/000/018/232/small_union-Berlin.jpg")) return "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/1._FC_Union_Berlin_Logo.svg/2000px-1._FC_Union_Berlin_Logo.svg.png"
    if (url.contains("http://upload.wikimedia.org/wikipedia/de/thumb/f/ff/1._FC_Saarbr%C3%BCcken.svg/150px-1._FC_Saarbr%C3%BCcken.svg.png")) return "https://upload.wikimedia.org/wikipedia/de/f/ff/1._FC_Saarbr%C3%BCcken.svg"
    if (url.contains("https://www.openligadb.de/images/teamicons/SC_Verl.gif")) return "https://upload.wikimedia.org/wikipedia/commons/c/ce/SC_Verl_Logo.svg"
    if (url.contains("https://www.openligadb.de/images/teamicons/Borussia_Dortmund.gif")) return "https://upload.wikimedia.org/wikipedia/commons/6/67/Borussia_Dortmund_logo.svg"
    if (url.contains("https://www.openligadb.de/images/teamicons/Rot_Weiss_Essen.gif")) return "https://upload.wikimedia.org/wikipedia/de/8/8a/Logo_Rot-Weiss_Essen.svg"
    if (url.contains("https://upload.wikimedia.org/wikipedia/de/thumb/5/55/FC-Ingolstadt_logo.svg/125px-FC-Ingolstadt_logo.svg.png")) return "https://upload.wikimedia.org/wikipedia/de/5/55/FC-Ingolstadt_logo.svg"
    if (url.contains("https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/Svwaldhof.svg/150px-Svwaldhof.svg.png")) return "https://upload.wikimedia.org/wikipedia/commons/1/17/Svwaldhof.svg"
    if (url.contains("https://upload.wikimedia.org/wikipedia/en/thumb/6/6d/SC_Freiburg_logo.svg/225px-SC_Freiburg_logo.svg.png")) return "https://upload.wikimedia.org/wikipedia/commons/f/f1/SC_Freiburg_Wappen.svg"
    if (url.contains("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/Logo_SG_Dynamo_Dresden_neu.svg/284px-Logo_SG_Dynamo_Dresden_neu.svg.png")) return "https://upload.wikimedia.org/wikipedia/commons/e/e1/Logo_SG_Dynamo_Dresden_neu.svg"
    if (url.contains(	"https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/SV_Meppen_Logo.svg/150px-SV_Meppen_Logo.svg.png")) return "https://upload.wikimedia.org/wikipedia/commons/5/55/SV_Meppen_Logo.svg"
    if (url.contains(	"https://upload.wikimedia.org/wikipedia/de/thumb/0/01/FSV_Zwickau_Logo.svg/120px-FSV_Zwickau_Logo.svg.png")) return "https://upload.wikimedia.org/wikipedia/de/0/01/FSV_Zwickau_Logo.svg"
    if (url.contains(	"https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/VfB_Oldenburg.svg/200px-VfB_Oldenburg.svg.png")) return "https://upload.wikimedia.org/wikipedia/commons/b/bc/VfB_Oldenburg.svg"
    if (url.contains(	"https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/Hallescher_FC.svg/150px-Hallescher_FC.svg.png")) return "https://upload.wikimedia.org/wikipedia/commons/e/e1/Hallescher_FC.svg"
    if (url.contains(   "https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Fortuna_D%C3%BCsseldorf.svg/150px-Fortuna_D%C3%BCsseldorf.svg.png")) return "https://upload.wikimedia.org/wikipedia/commons/9/94/Fortuna_D%C3%BCsseldorf.svg"
    if (url.contains(	"https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Holstein_Kiel_Logo.svg/300px-Holstein_Kiel_Logo.svg.png")) return "https://upload.wikimedia.org/wikipedia/commons/3/30/Holstein_Kiel_Logo.svg"
    if (url.contains(   "https://upload.wikimedia.org/wikipedia/commons/thumb/8/84/1._FC_Magdeburg.svg/210px-1._FC_Magdeburg.svg.png")) return "https://upload.wikimedia.org/wikipedia/commons/8/84/1._FC_Magdeburg.svg"
    if (url.contains("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Jahn_Regensburg_logo2014.svg/204px-Jahn_Regensburg_logo2014.svg.png")) return "https://upload.wikimedia.org/wikipedia/commons/5/5a/SSV_Jahn_Regensburg.svg"
    return url
}