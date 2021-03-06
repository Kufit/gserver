package org.gserver.gate;

import org.gserver.core.net.codec.HeaderDecoder;
import org.gserver.core.net.codec.HeaderEncoder;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;

public class GatePipelineFactory implements ChannelPipelineFactory {

	@Override
	public ChannelPipeline getPipeline() throws Exception {
		final GateHandler handler = new GateHandler();
		ChannelPipeline pipeline = Channels.pipeline();
		pipeline.addLast("decoder", new HeaderDecoder());
		pipeline.addLast("encoder", new HeaderEncoder());
		pipeline.addLast("handler", handler);
		return pipeline;
	}

}
