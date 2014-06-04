package net.joelinn.stripe.request;

import java.util.Date;

/**
 * User: Joe Linn
 * Date: 5/23/2014
 * Time: 2:55 PM
 */
public class CreatedRequest extends Request{
    protected Date gt;

    protected Date gte;

    protected Date lt;

    protected Date lte;

    public CreatedRequest setGt(Date gt) {
        this.gt = gt;
        return this;
    }

    public CreatedRequest setGte(Date gte) {
        this.gte = gte;
        return this;
    }

    public CreatedRequest setLt(Date lt) {
        this.lt = lt;
        return this;
    }

    public CreatedRequest setLte(Date lte) {
        this.lte = lte;
        return this;
    }
}
