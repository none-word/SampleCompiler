package Intepreter.Storage;

import Intepreter.Utils.Pair;
import sample.Absyn.*;

import java.util.HashMap;
import java.util.Objects;

public class TableStorage {
    private static final HashMap<String, Pair<InitDecl, InitDecl>> globalTableStorage = new HashMap<>();
    private final HashMap<String, Pair<InitDecl, InitDecl>> tableStorage = new HashMap<>();

    public Expr getTable(String ident, String field) {
        try {
            InitDecl localTableIdent1 = tableStorage.get(ident).getKey();
            InitDecl localTableIdent2 = tableStorage.get(ident).getValue();
            return Objects.equals(((Declaration) localTableIdent1.dec_).ident_, field) ?
                    localTableIdent1.expr_ :
                    localTableIdent2.expr_;
        } catch (NullPointerException e) {
            InitDecl globalTableIdent1 = globalTableStorage.get(ident).getKey();
            InitDecl globalTableIdent2 = globalTableStorage.get(ident).getValue();
            return Objects.equals(((Declaration) globalTableIdent1.dec_).ident_, field) ?
                    globalTableIdent1.expr_ :
                    globalTableIdent2.expr_;
        }
    }

    public void saveTable(TableDecl tableDecl) {
        tableStorage.put(((Declaration) tableDecl.dec_).ident_,
                new Pair<>(new InitDecl(new Declaration(tableDecl.ident_1, null), null),
                        new InitDecl(new Declaration(tableDecl.ident_2, null), null)));
    }

    public void saveTable(InitTableDecl tableDecl) {
        tableStorage.put(((Declaration) tableDecl.dec_1).ident_,
                new Pair<>(new InitDecl(tableDecl.dec_2, null),
                        new InitDecl(tableDecl.dec_3, null)));
    }

    public void saveGlobalTable(GlTableDecl tableDecl) {
        globalTableStorage.put(((GlDeclaration) tableDecl.gldec_).ident_,
                new Pair<>(new InitDecl(new Declaration(tableDecl.ident_1, null), null),
                        new InitDecl(new Declaration(tableDecl.ident_2, null), null)));
    }

    public void saveGlobalTable(InitGlTableDecl tableDecl) {
        globalTableStorage.put(((GlDeclaration) tableDecl.gldec_).ident_,
                new Pair<>(new InitDecl(tableDecl.dec_1, null),
                        new InitDecl(tableDecl.dec_2, null)));
    }

    public void updateTable(String ident, String field, Expr expr) {
        try {
            Pair<InitDecl, InitDecl> pair = tableStorage.get(ident);
            InitDecl localTableIdent1 = tableStorage.get(ident).getKey();
            InitDecl localTableIdent2 = tableStorage.get(ident).getValue();
            if (Objects.equals(((Declaration) localTableIdent1.dec_).ident_, field)) {
                pair.setKey(new InitDecl(localTableIdent1.dec_, expr));
            } else {
                pair.setValue(new InitDecl(localTableIdent2.dec_, expr));
            }
        } catch (NullPointerException e) {
            Pair<InitDecl, InitDecl> pair = globalTableStorage.get(ident);
            InitDecl globalTableIdent1 = globalTableStorage.get(ident).getKey();
            InitDecl globalTableIdent2 = globalTableStorage.get(ident).getValue();
            if (Objects.equals(((Declaration) globalTableIdent1.dec_).ident_, field)) {
                pair.setKey(new InitDecl(globalTableIdent1.dec_, expr));
            } else {
                pair.setValue(new InitDecl(globalTableIdent2.dec_, expr));
            }
        }
    }
}
