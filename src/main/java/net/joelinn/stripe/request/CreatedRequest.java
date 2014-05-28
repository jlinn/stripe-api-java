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

    public void setGt(Date gt) {
        this.gt = gt;
    }

    public void setGte(Date gte) {
        this.gte = gte;
    }

    public void setLt(Date lt) {
        this.lt = lt;
    }

    public void setLte(Date lte) {
        this.lte = lte;
    }
}
