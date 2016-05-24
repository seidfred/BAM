package de.seidfred.bam.model.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QFixValues is a Querydsl query type for FixValues
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QFixValues extends EntityPathBase<FixValues> {

    private static final long serialVersionUID = 1601076506L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFixValues fixValues = new QFixValues("fixValues");

    public final QAccount account;

    public final de.seidfred.bam.model.attribute.QFixValue fixValue;

    public final de.seidfred.bam.model.attribute.QIdentity id;

    public final EnumPath<de.seidfred.bam.model.enums.PeriodType> type = createEnum("type", de.seidfred.bam.model.enums.PeriodType.class);

    public QFixValues(String variable) {
        this(FixValues.class,  forVariable(variable), INITS);
    }

    public QFixValues(Path<? extends FixValues> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFixValues(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFixValues(PathMetadata<?> metadata, PathInits inits) {
        this(FixValues.class,  metadata, inits);
    }

    public QFixValues(Class<? extends FixValues> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new QAccount(forProperty("account"), inits.get("account")) : null;
        this.fixValue = inits.isInitialized("fixValue") ? new de.seidfred.bam.model.attribute.QFixValue(forProperty("fixValue")) : null;
        this.id = inits.isInitialized("id") ? new de.seidfred.bam.model.attribute.QIdentity(forProperty("id")) : null;
    }

}

