/*
 * This file is part of HE_Mesh, a library for creating and manipulating meshes.
 * It is dedicated to the public domain. To the extent possible under law,
 * I , Frederik Vanhoutte, have waived all copyright and related or neighboring
 * rights.
 *
 * This work is published from Belgium. (http://creativecommons.org/publicdomain/zero/1.0/)
 *
 */
package wblut.math;

/**
 *
 *
 * @author Frederik Vanhoutte, W:Blut
 *
 *         A parameter which is linear in a parameter, clamped or unclamped on a
 *         range. An easing function can be applied to the normalize parameter.
 */
public class WB_EaseScalarParameter implements WB_ScalarParameter {

	double lowT, highT;
	double lowValue, highValue;
	double rangeT, rangeValue;
	boolean clamp;
	WB_Ease.Ease ease;

	WB_Ease.EaseType type;

	public WB_EaseScalarParameter(final double lowT, final double highT, final double lowValue, final double highValue,
			final WB_Ease.Ease ease, final WB_Ease.EaseType type) {
		if (lowT <= highT) {
			this.lowT = lowT;
			this.highT = highT;
			this.lowValue = lowValue;
			this.highValue = highValue;
		} else {

			this.lowT = highT;
			this.highT = lowT;
			this.lowValue = highValue;
			this.highValue = lowValue;
		}
		rangeT = this.highT - this.lowT;
		rangeValue = this.highValue - this.lowValue;
		clamp = false;
		this.ease = ease;
		this.type = type;
	}

	public WB_EaseScalarParameter(final double lowT, final double highT, final double lowValue, final double highValue,
			final boolean clamp, final WB_Ease.Ease ease, final WB_Ease.EaseType type) {
		if (lowT <= highT) {
			this.lowT = lowT;
			this.highT = highT;
			this.lowValue = lowValue;
			this.highValue = highValue;
		} else {

			this.lowT = highT;
			this.highT = lowT;
			this.lowValue = highValue;
			this.highValue = lowValue;
		}
		rangeT = this.highT - this.lowT;
		rangeValue = this.highValue - this.lowValue;
		this.clamp = clamp;
		this.ease = ease;
		this.type = type;
	}

	public WB_EaseScalarParameter(final double lowT, final double highT, final double lowValue, final double highValue,
			final WB_Ease.Ease ease) {
		if (lowT <= highT) {
			this.lowT = lowT;
			this.highT = highT;
			this.lowValue = lowValue;
			this.highValue = highValue;
		} else {

			this.lowT = highT;
			this.highT = lowT;
			this.lowValue = highValue;
			this.highValue = lowValue;
		}
		rangeT = this.highT - this.lowT;
		rangeValue = this.highValue - this.lowValue;
		clamp = false;
		this.ease = ease;
		this.type = WB_Ease.EaseType.INOUT;
	}

	public WB_EaseScalarParameter(final double lowT, final double highT, final double lowValue, final double highValue,
			final boolean clamp, final WB_Ease.Ease ease) {
		if (lowT <= highT) {
			this.lowT = lowT;
			this.highT = highT;
			this.lowValue = lowValue;
			this.highValue = highValue;
		} else {

			this.lowT = highT;
			this.highT = lowT;
			this.lowValue = highValue;
			this.highValue = lowValue;
		}
		rangeT = this.highT - this.lowT;
		rangeValue = this.highValue - this.lowValue;
		this.clamp = clamp;
		this.ease = ease;
		this.type = WB_Ease.EaseType.INOUT;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see wblut.math.WB_ScalarParameter#evaluate(double[])
	 */
	@Override
	public double evaluate(final double... x) {
		if (rangeT == 0) {
			return lowValue;
		}
		if (clamp) {
			if (x[0] <= lowT) {
				return lowValue;
			}
			if (x[0] >= highT) {
				return highValue;
			}
		}
		double t = (x[0] - lowT) / rangeT;

		return ease.ease(type, t) * rangeValue + lowValue;
	}
}
