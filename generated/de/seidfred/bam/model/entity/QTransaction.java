package de.seidfred.bam.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QTransaction is a Querydsl query type for Transaction
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTransaction extends EntityPathBase<Transaction> {

    private static final long serialVersionUID = 138709409L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTransaction transaction = new QTransaction("transaction");

    public final QAccount account;

    public final de.seidfred.bam.model.attribute.QTransactionAmount amount;

    public final de.seidfred.bam.model.attribute.QTransactionDate date;

    public final de.seidfred.bam.model.attribute.QIdentity id;

    public final de.seidfred.bam.model.attribute.QUsage usage;

    public QTransaction(String variable) {
        this(Transaction.class,  forVariable(variable), INITS);
    }

    public QTransaction(Path<? extends Transaction> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTransaction(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTransaction(PathMetadata<?> metadata, PathInits inits) {
        this(Transaction.class,  metadata, inits);
    }

    public QTransaction(Class<? extends Transaction> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new QAccount(forProperty("account"), inits.get("account")) : null;
        this.amount = inits.isInitialized("amount") ? new de.seidfred.bam.model.attribute.QTransactionAmount(forProperty("amount")) : null;
        this.date = inits.isInitialized("date") ? new de.seidfred.bam.model.attribute.QTransactionDate(forProperty("date")) : null;
        this.id = inits.isInitialized("id") ? new de.seidfred.bam.model.attribute.QIdentity(forProperty("id")) : null;
        this.usage = inits.isInitialized("usage") ? new de.seidfred.bam.model.attribute.QUsage(forProperty("usage")) : null;
    }

}

