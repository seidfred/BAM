package de.seidfred.bam.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QAccount is a Querydsl query type for Account
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAccount extends EntityPathBase<Account> {

    private static final long serialVersionUID = 1729043056L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccount account = new QAccount("account");

    public final ListPath<Account, QAccount> childAccounts = this.<Account, QAccount>createList("childAccounts", Account.class, QAccount.class, PathInits.DIRECT2);

    public final de.seidfred.bam.model.attribute.QDescription description;

    public final ListPath<FixValues, QFixValues> fixValues = this.<FixValues, QFixValues>createList("fixValues", FixValues.class, QFixValues.class, PathInits.DIRECT2);

    public final de.seidfred.bam.model.attribute.QIdentity id;

    public final QAccount mainAccount;

    public final de.seidfred.bam.model.attribute.QAccountName name;

    public final ListPath<Transaction, QTransaction> transactions = this.<Transaction, QTransaction>createList("transactions", Transaction.class, QTransaction.class, PathInits.DIRECT2);

    public QAccount(String variable) {
        this(Account.class,  forVariable(variable), INITS);
    }

    public QAccount(Path<? extends Account> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAccount(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAccount(PathMetadata<?> metadata, PathInits inits) {
        this(Account.class,  metadata, inits);
    }

    public QAccount(Class<? extends Account> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.description = inits.isInitialized("description") ? new de.seidfred.bam.model.attribute.QDescription(forProperty("description")) : null;
        this.id = inits.isInitialized("id") ? new de.seidfred.bam.model.attribute.QIdentity(forProperty("id")) : null;
        this.mainAccount = inits.isInitialized("mainAccount") ? new QAccount(forProperty("mainAccount"), inits.get("mainAccount")) : null;
        this.name = inits.isInitialized("name") ? new de.seidfred.bam.model.attribute.QAccountName(forProperty("name")) : null;
    }

}

