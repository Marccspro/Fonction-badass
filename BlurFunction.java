	/**
	 * Returns the source with a number of blur passes you define.
	 * 
	 * @param source - The source array [x][y].
	 * @param w - The width of the source.
	 * @param h - The height of the source.
	 * @param blurPasses - The number of blur passes.
	 * @return Returns the blurred source.
	 */
	public float[][] applyBlur(float[][] source, int w, int h, int blurPasses) {
		float[][] result = new float[w][h];
		
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++) {
				
				float val = 0;
				
				for (int iy = i - blurPasses; iy < i + blurPasses + 1; iy++) {
					for (int ix = j - blurPasses; ix < j + blurPasses + 1; ix++) {
						int x = ix;
						int y = iy;
						
						if (ix < 0) x = 0;
						if (iy < 0) y = 0;
						if (ix >= w - blurPasses) x = w - blurPasses - 1;
						if (iy >= h - blurPasses) y = h - blurPasses - 1;
						
						val += source[x][y];
					}
				}

				result[i][j] = val / (float) ((blurPasses + blurPasses + 1) * (float) (blurPasses + blurPasses + 1));
			}
		return result;
	}
