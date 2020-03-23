package com.winkelmann.swl.dc.common.exception.file;

import com.winkelmann.swl.dc.common.exception.BaseException;

public class FileException extends BaseException
{
	private static final long serialVersionUID = 1L;
	
	public FileException(String code, Object[] args)
	{
		super("file", code, args, null);
	}
}
